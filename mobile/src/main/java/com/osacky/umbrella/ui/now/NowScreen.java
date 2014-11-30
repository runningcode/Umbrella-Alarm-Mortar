package com.osacky.umbrella.ui.now;

import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.R;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.Path;
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

@Layout(R.layout.view_weather_now)
public class NowScreen extends Path {

    @Override public Object getDaggerModule() {
        return new Module(getViewState());
    }

    @dagger.Module(
            injects = NowView.class,
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
    public static class Presenter extends BetterViewPresenter<NowView> {

        private final Observable<WeatherResult> mObservable;
        private final WeatherToNow mWeatherToNow;

        @Inject
        public Presenter(
                SparseArray<Parcelable> viewState,
                BaseTabScreen.Presenter basePresenter,
                WeatherToNow weatherToNow
        ) {
            super(viewState);
            mObservable = basePresenter.getObservable();
            mWeatherToNow = weatherToNow;
        }

        Subscription getSubscription(Observer<NowWeatherSummary> observer) {
            return mObservable.map(mWeatherToNow)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }
    }

}
