package com.osacky.umbrella.data.api;

import android.support.annotation.NonNull;

import com.osacky.umbrella.data.api.model.WeatherResult;
import com.osacky.umbrella.data.manager.DataManager;

import rx.Observable;

public class ForecastWeatherManager extends DataManager<WeatherResult, Double> {

    public ForecastWeatherManager(WeatherService api) {
        super(api);
    }

    @NonNull @Override
    protected Observable<WeatherResult> fetchFromResponseCache(Double key, Double... floats) {
        return Observable.empty();
    }

    @NonNull @Override
    protected Observable<WeatherResult> fetchFromInternet(Double key, Double... floats) {
        return getApi().getWeather(key, floats[0]);
    }
}
