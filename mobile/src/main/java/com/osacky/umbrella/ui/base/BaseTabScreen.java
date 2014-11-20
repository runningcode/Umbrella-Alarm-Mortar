package com.osacky.umbrella.ui.base;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.MenuItem;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.osacky.umbrella.R;
import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.anim.Transition;
import com.osacky.umbrella.core.presenters.ConnectedPresenter;
import com.osacky.umbrella.core.presenters.ConnectionCallbacksRegistrar;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.TransitionScreen;
import com.osacky.umbrella.data.api.ForecastWeatherManager;
import com.osacky.umbrella.data.api.model.RainSummary;
import com.osacky.umbrella.data.api.model.WeatherResult;
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
import mortar.MortarScope;
import retrofit.RetrofitError;
import rx.Observable;
import rx.RetrofitObserver;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import timber.log.Timber;

@Layout(R.layout.view_base_weather)
@Transition({R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right})
public class BaseTabScreen extends TransitionScreen {

    @Override public Object getDaggerModule() {
        return new Module(mViewState);
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
    public static class Presenter extends BetterViewPresenter<BaseTabView> implements
            GoogleApiClient.ConnectionCallbacks {

        private final Flow mFlow;
        private final Observable<WeatherResult> mObservable;
        private final ConnectedPresenter mConnectedPresenter;
        private Subscription mSubscription;

        @Inject
        public Presenter(
                @Named("tabs") SparseArray<Parcelable> viewState,
                Provider<Location> locationProvider,
                ForecastWeatherManager weatherManager,
                WeatherToDailySummary weatherToDailySummary,
                final Flow flow,
                final ConnectedPresenter connectedPresenter
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
            mObservable = weatherManager.get(location.getLatitude(), location.getLongitude());
            mSubscription = mObservable.map(new Func1<WeatherResult, WeatherResult>() {
                @Override public WeatherResult call(WeatherResult weatherResult) {
                    new SendDataThread(weatherResult, mConnectedPresenter.getGoogleApiClient()).start();
                    return weatherResult;
                }
            })
                    .map(weatherToDailySummary)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(new Action1<RainSummary>() {
                        @Override public void call(RainSummary rainSummary) {
                            if (rainSummary == null) return;
                            getView().setTitle(rainSummary.getCityName());
                        }
                    })
                    .subscribe(new RetrofitObserver<RainSummary>() {
                        @Override public void onRetrofitError(RetrofitError e) {}
                        @Override public void onNext(RainSummary rainSummary) {

                        }
                    });
        }

        @Override protected void onEnterScope(MortarScope scope) {
            super.onEnterScope(scope);
            mConnectedPresenter.register(scope, this);
        }

        @Override public void onLoad(Bundle savedInstanceState) {
            super.onLoad(savedInstanceState);
            restoreViewState();
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

        @Override public void onConnected(Bundle bundle) {
            mConnectedPresenter.getGoogleApiClient();
        }

        @Override public void onConnectionSuspended(int i) {

        }
    }

   static class SendDataThread extends Thread {
       private final WeatherResult mWeatherResult;
       private final GoogleApiClient mGoogleApiClient;

       SendDataThread(WeatherResult weatherResult, GoogleApiClient googleApiClient) {
           mWeatherResult = weatherResult;
           mGoogleApiClient = googleApiClient;
       }

       @Override public void run() {
           Timber.i("running send data thread");
           if(!mGoogleApiClient.isConnected()) {
               ConnectionResult connectionResult = mGoogleApiClient
                       .blockingConnect(30, TimeUnit.SECONDS);
               if (!connectionResult.isSuccess()) {
                   Timber.e("Failed to connect to GoogleApiClient.");
                   return;
               }
           }
           PutDataMapRequest dataMap = PutDataMapRequest.create("/weather");
           int temp = (int) mWeatherResult.getCurrently().getTemperature();
           Timber.i("sending temp %d", temp);
           Timber.i("sending current summary %s", mWeatherResult.getCurrently().getSummary());
           dataMap.getDataMap().putInt("temp_F", temp);
           dataMap.getDataMap().putString("current_summary", mWeatherResult.getCurrently().getSummary());

           PutDataRequest request = dataMap.asPutDataRequest();
           DataApi.DataItemResult await = Wearable.DataApi.putDataItem(mGoogleApiClient,
                   request).await();
           if (await.getStatus().isSuccess()) {
               Timber.i("onSuccess");
           } else {
               Timber.e("onFailed");
           }
       }
   }
}
