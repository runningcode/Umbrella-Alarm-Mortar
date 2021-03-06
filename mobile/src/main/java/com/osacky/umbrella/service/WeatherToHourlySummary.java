package com.osacky.umbrella.service;

import com.osacky.umbrella.data.api.WeatherGeoCoder;
import com.osacky.umbrella.data.api.model.RainSummary;
import com.osacky.umbrella.data.api.model.WeatherResult;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.functions.Func1;

@Singleton
public class WeatherToHourlySummary implements Func1<WeatherResult, RainSummary> {

    private final WeatherGeoCoder mWeatherGeoCoder;

    @Inject
    public WeatherToHourlySummary(WeatherGeoCoder geoCoder) {
        mWeatherGeoCoder = geoCoder;
    }

    @Override public RainSummary call(WeatherResult weatherForecastResult) {
        if (weatherForecastResult == null) {
            return null;
        }
        return new RainSummary(
                weatherForecastResult.getMinutely().getSummary(),
                mWeatherGeoCoder.getCityForLocation(weatherForecastResult.getLatitude(),
                        weatherForecastResult.getLongitude()),
                weatherForecastResult.getDaily().getData().get(0).getPrecipProbability());
    }
}
