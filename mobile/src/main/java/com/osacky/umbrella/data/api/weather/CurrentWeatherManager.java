package com.osacky.umbrella.data.api.weather;

import android.support.annotation.NonNull;

import com.osacky.umbrella.data.api.model.OpenWeatherService;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;
import com.osacky.umbrella.data.manager.DataManager;

import rx.Observable;

public class CurrentWeatherManager extends DataManager<WeatherForecastResult, Double> {

    public CurrentWeatherManager(OpenWeatherService api) {
        super(api);
    }

    @NonNull @Override
    protected Observable<WeatherForecastResult> fetchFromResponseCache(Double key, Double... floats) {
        return Observable.empty();
    }

    @NonNull @Override
    protected Observable<WeatherForecastResult> fetchFromInternet(Double key, Double... floats) {
        return getApi().getWeatherForecast(key, floats[0]);
    }
}
