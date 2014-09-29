package com.osacky.umbrella.ui.forecast;

import com.osacky.umbrella.data.api.model.WeatherResult;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.functions.Func1;

@Singleton
public class WeatherToForecast implements Func1<WeatherResult, ForecastWeatherSummary> {

    @Inject WeatherToForecast() {}

    @Override public ForecastWeatherSummary call(WeatherResult weatherResult) {
        if (weatherResult == null) {
            return null;
        }

        return new ForecastWeatherSummary(
                weatherResult.getDaily().getSummary(),
                weatherResult.getDaily());
    }
}
