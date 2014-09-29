package com.osacky.umbrella.ui.hourly;

import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.R;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.StateBlueprint;
import com.osacky.umbrella.data.api.model.WeatherResult;
import com.osacky.umbrella.ui.base.BaseTabScreen;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Layout;
import rx.Observable;
import rx.Observer;
import rx.Subscription;

@Layout(R.layout.view_weather_today)
public class TodayScreen implements StateBlueprint {

    private SparseArray<Parcelable> mViewState;

    @Override public String getMortarScopeName() {
        return TodayScreen.class.getName();
    }

    @Override public Object getDaggerModule() {
        return new Module(mViewState);
    }

    @Override public void setViewState(SparseArray<Parcelable> viewState) {
        mViewState = viewState;
    }

    @dagger.Module(
            injects = TodayView.class,
            addsTo = BaseTabScreen.Module.class
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
    public static class Presenter extends BetterViewPresenter<TodayView> {

        private final Observable<WeatherResult> mObservable;
        private final WeatherToToday mWeatherToToday;

        @Inject
        public Presenter(
                SparseArray<Parcelable> viewState,
                BaseTabScreen.Presenter basePresenter,
                WeatherToToday weatherToToday
        ) {
            super(viewState);
            mObservable = basePresenter.getObservable();
            mWeatherToToday = weatherToToday;
        }

        Subscription getSubscription(Observer<TodayWeatherSummary> observer) {
            return mObservable.map(mWeatherToToday).subscribe(observer);
        }
    }

}
