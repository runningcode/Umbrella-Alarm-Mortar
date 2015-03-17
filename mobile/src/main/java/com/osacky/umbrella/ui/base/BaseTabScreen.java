package com.osacky.umbrella.ui.base;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.MenuItem;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.osacky.umbrella.R;
import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.anim.Transition;
import com.osacky.umbrella.core.presenters.ConnectedPresenter;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.TransitionScreen;
import com.osacky.umbrella.data.api.ForecastWeatherManager;
import com.osacky.umbrella.data.api.model.RainSummary;
import com.osacky.umbrella.data.api.model.WeatherResult;
import rx.RxUtils;
import com.osacky.umbrella.service.WeatherToDailySummary;
import com.osacky.umbrella.ui.notifications.NotificationsScreen;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Flow;
import flow.Layout;
import retrofit.RetrofitError;
import rx.Observable;
import rx.RetrofitObserver;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;
import timber.log.Timber;

@Layout(R.layout.view_base_weather)
@Transition({R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right})
public class BaseTabScreen extends TransitionScreen {

    @Override public Object getDaggerModule() {
        return new Module(getViewState());
    }

    @dagger.Module(
            injects = BaseTabView.class,
            addsTo = CorePresenter.Module.class,
            library = true
    )
    public static class Module {
        private final SparseArray<Parcelable> viewState;

        public Module(SparseArray<Parcelable> viewState) {
            this.viewState = viewState;
        }

        @Provides @Named("tabs") SparseArray<Parcelable> providesViewState() {
            return viewState;
        }
    }

    @Singleton
    public static class Presenter extends BetterViewPresenter<BaseTabView> {

        private final Flow mFlow;
        private final Observable<WeatherResult> mObservable;
        private final ConnectedPresenter mConnectedPresenter;
        private Subscription mSubscription;

        private CharSequence mCityName;

        @Inject
        public Presenter(
                @Named("tabs") SparseArray<Parcelable> viewState,
                Provider<Location> locationProvider,
                ForecastWeatherManager weatherManager,
                WeatherToDailySummary weatherToDailySummary,
                Flow flow,
                ConnectedPresenter connectedPresenter,
                final BehaviorSubject<WeatherResult> weatherResultSubject
        ) {
            super(viewState);
            mFlow = flow;
            Location location = locationProvider.get();
            mConnectedPresenter = connectedPresenter;
            if (location == null) {
                mObservable = Observable.empty();
                // TODO do something
                Timber.e("Location was null");
                return;
            }
            mObservable = RxUtils.cacheAndReplay(weatherManager.get(location.getLatitude(), location.getLongitude()));
            mSubscription = mObservable.map(new Func1<WeatherResult, WeatherResult>() {
                @Override public WeatherResult call(WeatherResult weatherResult) {
//                    weatherResultSubject.onNext(weatherResult);
                    GoogleApiClient client = mConnectedPresenter.getGoogleApiClient();
                    if (client != null) {
                        new SendDataThread(weatherResult, client).start();
                    }
                    return weatherResult;
                }
            })
                    .map(weatherToDailySummary)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new RetrofitObserver<RainSummary>() {
                        @Override public void onRetrofitError(RetrofitError e) {
                        }

                        @Override public void onNext(RainSummary rainSummary) {
                            if (rainSummary == null) return;
                            mCityName = rainSummary.getCityName().toString();
                            getView().setTitle(mCityName);
                        }
                    });
        }

        @Override public void onLoad(Bundle savedInstanceState) {
            super.onLoad(savedInstanceState);
            getView().setMenu(R.menu.about, new Toolbar.OnMenuItemClickListener() {
                @Override public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.about:
                            return true;
                        case R.id.notification:
                            mFlow.goTo(new NotificationsScreen());
                            return true;
                    }
                    return false;
                }
            });
            if (savedInstanceState != null) {
                String cityName = savedInstanceState.getString("cityName");
                if (cityName != null) {
                    getView().setTitle(mCityName);
                }
            }
        }

        @Override protected void onSave(Bundle outState) {
            super.onSave(outState);
            if (mCityName != null) {
                outState.putString("cityName", mCityName.toString());
            }
        }

        @Override protected void onExitScope() {
            if (mSubscription != null) {
                mSubscription.unsubscribe();
            }
            super.onExitScope();
        }

        public Observable<WeatherResult> getObservable(){
            return mObservable;
        }
    }

   private static class SendDataThread extends Thread {
       private final WeatherResult mWeatherResult;
       private final GoogleApiClient mGoogleApiClient;

       public static final String WEATHER_PATH = "/weather";
       public static final String TEMP_KEY = "temp_F";
       private static final String SUMMARY_KEY = "weather_summary";

       SendDataThread(WeatherResult weatherResult, GoogleApiClient googleApiClient) {
           mWeatherResult = weatherResult;
           mGoogleApiClient = googleApiClient;
       }

       @Override public void run() {
           if(!mGoogleApiClient.isConnected()) {
               ConnectionResult connectionResult = mGoogleApiClient
                       .blockingConnect(30, TimeUnit.SECONDS);
               if (!connectionResult.isSuccess()) {
                   Timber.e("Failed to connect to GoogleApiClient.");
                   return;
               }
           }
           PutDataMapRequest dataMap = PutDataMapRequest.create(WEATHER_PATH);
           int temp = (int) mWeatherResult.getCurrently().getTemperature();
           Timber.i("Temp is %d weather is %s", temp, mWeatherResult.getCurrently().getSummary());
           dataMap.getDataMap().putInt(TEMP_KEY, temp);
           dataMap.getDataMap().putString(SUMMARY_KEY, mWeatherResult.getCurrently().getSummary());

           PutDataRequest request = dataMap.asPutDataRequest();
           Wearable.DataApi.putDataItem(mGoogleApiClient, request).await();
       }
   }
}
