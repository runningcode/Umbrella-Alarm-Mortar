package com.osacky.umbrella.ui.test;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.osacky.umbrella.R;
import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.actionbar.ActionBarConfig;
import com.osacky.umbrella.actionbar.ActionBarOwner;
import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.anim.Transition;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.TransitionScreen;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;
import com.osacky.umbrella.data.api.weather.CurrentWeatherManager;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.annotations.TimePref;
import com.osacky.umbrella.ui.time.TimeInfo;

import org.joda.time.LocalTime;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Flow;
import flow.Layout;
import mortar.PopupPresenter;
import rx.Observer;
import rx.Subscription;
import rx.subjects.PublishSubject;
import timber.log.Timber;

@Layout(R.layout.view_weather)
@Transition({R.animator.slide_in_right, R.animator.slide_out_left, R.animator.slide_in_left, R.animator.slide_out_right})
public class WeatherScreen extends TransitionScreen {
    @Override public String getMortarScopeName() {
        return WeatherScreen.class.getName();
    }

    @Override public Object getDaggerModule() {
        return new Module(getViewState());
    }

    @dagger.Module(
            injects = WeatherView.class,
            addsTo = CorePresenter.Module.class,
            library = true
    )
    static class Module {
        private final SparseArray<Parcelable> viewState;

        public Module(SparseArray<Parcelable> viewState) {
            this.viewState = viewState;
        }

        @Provides SparseArray<Parcelable> providesViewState() {
            return viewState;
        }
    }

    @Singleton
    public static class Presenter extends BetterViewPresenter<WeatherView>
        implements GooglePlayServicesClient.ConnectionCallbacks,
            GooglePlayServicesClient.OnConnectionFailedListener {

        private final Flow mFlow;
        private final CurrentWeatherManager mWeatherManager;
        private final PopupPresenter<TimeInfo, LocalTime> mPopupPresenter;
        private final IntPreference mTimePreference;
        private final ActionBarOwner mActionBarOwner;
        private final ActionBarConfig mActionBarConfig;
        private final LocationClient mLocationClient;

        private PublishSubject<WeatherForecastResult> mSubject;

        @Inject
        public Presenter(
                SparseArray<Parcelable> viewState,
                Flow flow,
                ActionBarOwner actionBarOwner,
                CurrentWeatherManager weatherManager,
                @TimePref IntPreference timePreference,
                UmbrellaApplication app
        ) {
            super(viewState);
            mFlow = flow;
            mWeatherManager = weatherManager;
            mTimePreference = timePreference;
            mActionBarOwner = actionBarOwner;
            mActionBarConfig = new ActionBarConfig.Builder().build();
            mLocationClient = new LocationClient(app, this, this);
            mSubject = PublishSubject.create();
            mPopupPresenter = new PopupPresenter<TimeInfo, LocalTime>() {
                @Override protected void onPopupResult(LocalTime result) {
                    Timber.d("Time set to %s", result);
                    mTimePreference.set(result.getMillisOfDay());
                }
            };
        }

        @Override public void onLoad(Bundle savedInstanceState) {
            super.onLoad(savedInstanceState);
            WeatherView view = getView();
            if (view == null) return;
            mPopupPresenter.takeView(view.getPopup());
            mActionBarOwner.setConfig(mActionBarConfig);
            mLocationClient.connect();

        }

        @Override public void dropView(WeatherView view) {
            super.dropView(view);
            mLocationClient.disconnect();
            mPopupPresenter.dropView(view.getPopup());
        }

        public Subscription getSubscription(Observer<WeatherForecastResult> resultObserver) {
            return mSubject.subscribe(resultObserver);
        }

        public void onTimeClicked() {
            mPopupPresenter.show(new TimeInfo(LocalTime.fromMillisOfDay(mTimePreference.get())));
        }

        @Override public void onConnected(Bundle bundle) {
            Location lastLocation = mLocationClient.getLastLocation();
            mWeatherManager.get(lastLocation.getLatitude(), lastLocation.getLongitude())
                    .subscribe(mSubject);
        }

        @Override public void onDisconnected() {

        }

        @Override public void onConnectionFailed(ConnectionResult connectionResult) {

        }
    }
}
