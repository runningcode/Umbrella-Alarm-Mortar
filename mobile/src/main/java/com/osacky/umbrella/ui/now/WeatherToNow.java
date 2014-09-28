package com.osacky.umbrella.ui.now;

import com.osacky.umbrella.data.api.model.WeatherResult;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.functions.Func1;

@Singleton
public class WeatherToNow implements Func1<WeatherResult, NowWeatherSummary> {

    @Inject WeatherToNow() {}

    @Override public NowWeatherSummary call(WeatherResult weatherResult) {
        if (weatherResult == null) {
            return null;
        }

        return new NowWeatherSummary(
                weatherResult.getCurrently().getTemperature(),
                weatherResult.getCurrently().getApparentTemperature(),
                weatherResult.getCurrently().getSummary(),
                weatherResult.getMinutely());
    }
}
