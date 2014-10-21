package com.osacky.umbrella.ui.forecast;

import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.R;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.StateBlueprint;
import com.osacky.umbrella.ui.base.BaseTabScreen;
import com.osacky.umbrella.util.ObjectUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Layout;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

@Layout(R.layout.view_weather_forecast)
public class ForecastScreen implements StateBlueprint {

    private SparseArray<Parcelable> mViewState;

    @Override public String getMortarScopeName() {
        return ObjectUtils.getClass(this).getName();
    }

    @Override public Object getDaggerModule() {
        return new Module(mViewState);
    }

    @Override public void setViewState(SparseArray<Parcelable> viewState) {
        mViewState = viewState;
    }

    @dagger.Module(
            injects = ForecastView.class,
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
    public static class Presenter extends BetterViewPresenter<ForecastView> {

        private final Observable<ForecastWeatherSummary> mObservable;
        private final ForecastAdapter mForecastAdapter;

        @Inject
        public Presenter(
                SparseArray<Parcelable> viewState,
                BaseTabScreen.Presenter basePresenter,
                final WeatherToForecast weatherToForecast,
                ForecastAdapter forecastAdapter
        ) {
            super(viewState);
            mForecastAdapter = forecastAdapter;
            mObservable = basePresenter.getObservable()
                    .map(weatherToForecast)
                    .doOnNext(new Action1<ForecastWeatherSummary>() {
                        @Override public void call(ForecastWeatherSummary weatherSummary) {
                            mForecastAdapter.setForecastList(weatherSummary.getDaily().getData());
                        }
                    });
        }

        Subscription getSubscription(Observer<ForecastWeatherSummary> observer) {
            return mObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
        }

        public ForecastAdapter getForecastAdapter() {
            return mForecastAdapter;
        }
    }

}
