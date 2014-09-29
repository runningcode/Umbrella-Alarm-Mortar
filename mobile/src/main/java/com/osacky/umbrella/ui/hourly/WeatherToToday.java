package com.osacky.umbrella.ui.hourly;

import com.osacky.umbrella.data.api.model.WeatherResult;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.functions.Func1;

@Singleton
public class WeatherToToday implements Func1<WeatherResult, TodayWeatherSummary> {

    @Inject WeatherToToday() {}

    @Override public TodayWeatherSummary call(WeatherResult weatherResult) {
        if (weatherResult == null) {
            return null;
        }

        return new TodayWeatherSummary(
                weatherResult.getDaily().getData().get(0).getTemperatureMin(),
                weatherResult.getDaily().getData().get(0).getTemperatureMax(),
                weatherResult.getHourly().getSummary(),
                weatherResult.getDaily().getData().get(0).getPrecipProbability(),
                weatherResult.getHourly());
    }
}
