package com.osacky.umbrella.ui.forecast;

import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.R;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.Path;
import com.osacky.umbrella.ui.base.BaseTabScreen;

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
public class ForecastScreen extends Path {

    @Override public Object getDaggerModule() {
        return new Module(getViewState());
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
                final ForecastAdapter forecastAdapter
        ) {
            super(viewState);
            mForecastAdapter = forecastAdapter;
            mObservable = basePresenter.getObservable()
                    .map(weatherToForecast);
            mObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer
                    <ForecastWeatherSummary>() {
                @Override public void onCompleted() {
                }

                @Override public void onError(Throwable e) {
                }

                @Override public void onNext(ForecastWeatherSummary forecastWeatherSummary) {
                    mForecastAdapter.setForecastList(forecastWeatherSummary.getDaily().getData());
                }
            });
        }

        Subscription getSubscription(Observer<ForecastWeatherSummary> observer) {
            return mObservable.observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }

        public ForecastAdapter getForecastAdapter() {
            return mForecastAdapter;
        }
    }
}
