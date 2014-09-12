package com.osacky.umbrella.ui.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
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
import com.osacky.umbrella.mortar.ActivityPresenter;
import com.osacky.umbrella.mortar.ActivityResultInterface;
import com.osacky.umbrella.mortar.ActivityResultRegistrar;
import com.osacky.umbrella.mortar.PauseAndResumeRegistrar;
import com.osacky.umbrella.mortar.PausesAndResumes;
import com.osacky.umbrella.util.Play;

import org.joda.time.LocalTime;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Layout;
import hugo.weaving.DebugLog;
import mortar.MortarScope;
import retrofit.RetrofitError;
import rx.RetrofitObserver;
import rx.Subscription;
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
        implements PausesAndResumes, ActivityResultInterface,
            GooglePlayServicesClient.ConnectionCallbacks,
            GooglePlayServicesClient.OnConnectionFailedListener {

        private final CurrentWeatherManager mWeatherManager;
        private final IntPreference mTimePreference;
        private final ActionBarOwner mActionBarOwner;
        private final ActionBarConfig mActionBarConfig;
        private final LocationClient mLocationClient;
        private final PauseAndResumeRegistrar pauseAndResumeRegistrar;
        private final ActivityResultRegistrar mResultRegistrar;
        private final ActivityPresenter mActivityPresenter;
        private final Provider<Location> mLocationProvider;

        private Subscription mSubscription;

        @Inject
        public Presenter(
                SparseArray<Parcelable> viewState,
                ActionBarOwner actionBarOwner,
                CurrentWeatherManager weatherManager,
                @TimePref IntPreference timePreference,
                UmbrellaApplication app,
                PauseAndResumeRegistrar resumeRegistrar,
                ActivityResultRegistrar resultRegistrar,
                ActivityPresenter activityPresenter,
                Provider<Location> locationProvider
        ) {
            super(viewState);
            mWeatherManager = weatherManager;
            mTimePreference = timePreference;
            mActionBarOwner = actionBarOwner;
            pauseAndResumeRegistrar = resumeRegistrar;
            mResultRegistrar = resultRegistrar;
            mActivityPresenter = activityPresenter;
            mLocationProvider = locationProvider;
            mActionBarConfig = new ActionBarConfig.Builder().build();
            mLocationClient = new LocationClient(app, this, this);
        }

        @Override protected void onEnterScope(MortarScope scope) {
            super.onEnterScope(scope);
            pauseAndResumeRegistrar.register(scope, this);
            mResultRegistrar.register(scope, this);
        }

        @Override public void onLoad(Bundle savedInstanceState) {
            super.onLoad(savedInstanceState);
            mActionBarOwner.setConfig(mActionBarConfig);
        }

        @Override protected void onExitScope() {
            mSubscription.unsubscribe();
            super.onExitScope();
        }

        @Override public void onConnected(Bundle bundle) {
            Location lastLocation = mLocationClient.getLastLocation();
            Timber.i("Last location is %s", lastLocation);
            Timber.i("Not google location is %s", mLocationProvider.get());
            mSubscription = mWeatherManager.get(lastLocation.getLatitude(), lastLocation.getLongitude())
                    .subscribe(new RetrofitObserver<WeatherForecastResult>() {
                        @Override public void onNext(WeatherForecastResult weatherForecastResult) {
                            getView().onWeatherForecast(weatherForecastResult);
                        }

                        @Override public void onRetrofitError(RetrofitError e) {
                        }
                    });
        }

        @Override public void onDisconnected() {
        }

        @Override public void onConnectionFailed(ConnectionResult connectionResult) {
        }

        @DebugLog
        @Override public void onResume() {
            if (Play.servicesConnected(mActivityPresenter.getActivity())) {
                mLocationClient.connect();
            }
        }

        @DebugLog
        @Override public void onPause() {
            mLocationClient.disconnect();
        }

        @Override @DebugLog
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            switch (requestCode) {
                case Play.CONNECTION_FAILURE_RESOLUTION_REQUEST:
                    switch (resultCode) {
                        case Activity.RESULT_OK:
                            mLocationClient.connect();
                            break;
                        case Activity.RESULT_CANCELED:
                            ErrorDialogFragment fragment = new ErrorDialogFragment();
                            fragment.setDialog(new AlertDialog.Builder(getView().getContext())
                                    .setMessage(R.string.play_error_close)
                                    .setPositiveButton(android.R.string.ok,
                                            new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    mActivityPresenter.getActivity().finish();
                                                }
                                            })
                                    .setCancelable(false)
                                    .create());
                            fragment.show(mActivityPresenter.getActivity().getSupportFragmentManager(), "Play Error");
                            break;
                    }
            }
        }

        public void onTimeChanged(int hourOfDay, int minute) {
            mTimePreference.set(new LocalTime(hourOfDay, minute).getMillisOfDay());
        }
    }

}
