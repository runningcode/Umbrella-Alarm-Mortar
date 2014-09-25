package com.osacky.umbrella.ui.test;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.R;
import com.osacky.umbrella.actionbar.ActionBarConfig;
import com.osacky.umbrella.actionbar.ActionBarOwner;
import com.osacky.umbrella.alarm.AlarmHelper;
import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.anim.Transition;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.StateBlueprint;
import com.osacky.umbrella.core.util.TransitionScreen;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;
import com.osacky.umbrella.data.api.weather.CurrentWeatherManager;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.annotations.TimePref;

import org.joda.time.LocalTime;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Layout;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action0;
import timber.log.Timber;

@Layout(R.layout.view_weather)
@Transition({R.animator.slide_in_right, R.animator.slide_out_left, R.animator.slide_in_left, R.animator.slide_out_right})
public class WeatherScreen extends TransitionScreen implements StateBlueprint {

    private SparseArray<Parcelable> mViewState;

    @Override public String getMortarScopeName() {
        return WeatherScreen.class.getName();
    }

    @Override public Object getDaggerModule() {
        return new Module(mViewState);
    }

    @Override public void setViewState(SparseArray<Parcelable> viewState) {
        mViewState = viewState;
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
    public static class Presenter extends BetterViewPresenter<WeatherView> {

        private final CurrentWeatherManager mWeatherManager;
        private final IntPreference mTimePreference;
        private final ActionBarOwner mActionBarOwner;
        private final ActionBarConfig mActionBarConfig;
        private final Provider<Location> mLocationProvider;
        private final Observable<WeatherForecastResult> mObservable;
        private final AlarmHelper mAlarmHelper;

        @Inject
        public Presenter(
                SparseArray<Parcelable> viewState,
                ActionBarOwner actionBarOwner,
                CurrentWeatherManager weatherManager,
                @TimePref IntPreference timePreference,
                Provider<Location> locationProvider,
                AlarmHelper alarmHelper
        ) {
            super(viewState);
            mWeatherManager = weatherManager;
            mTimePreference = timePreference;
            mActionBarOwner = actionBarOwner;
            mLocationProvider = locationProvider;
            mAlarmHelper = alarmHelper;
            mActionBarConfig = new ActionBarConfig.Builder()
                    .menu(R.menu.about, new ActionBarOwner.MenuAction(R.id.about, new Action0() {
                        @Override public void call() {
                            // TODO show popup
                        }
                    }))
                    .build();
            Location lastLocation = mLocationProvider.get();
            Timber.i("Last known location is %s", lastLocation);
            mObservable = mWeatherManager.get(lastLocation.getLatitude(), lastLocation.getLongitude());
        }

        @Override public void onLoad(Bundle savedInstanceState) {
            super.onLoad(savedInstanceState);
            mActionBarOwner.setConfig(mActionBarConfig);
        }

        void onTimeChanged(int hourOfDay, int minute) {
            mTimePreference.set(new LocalTime(hourOfDay, minute).getMillisOfDay());
            mAlarmHelper.setAlarm();
        }

        LocalTime getDefaultTime() {
            return LocalTime.fromMillisOfDay(mTimePreference.get());
        }

        Subscription getSubscription(Observer<WeatherForecastResult> observer) {
            return mObservable.subscribe(observer);
        }
    }

}
