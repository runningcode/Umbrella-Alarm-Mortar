package com.osacky.umbrella.ui.hourly;

import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.R;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.Screen;
import com.osacky.umbrella.data.api.model.WeatherResult;
import com.osacky.umbrella.ui.base.BaseTabScreen;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Layout;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

@Layout(R.layout.view_weather_today)
public class TodayScreen extends Screen {

    @Override public Object getDaggerModule() {
        return new Module(mViewState);
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
            return mObservable.map(mWeatherToToday)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }
    }

}
