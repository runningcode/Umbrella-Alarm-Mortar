package com.osacky.umbrella.service;

import com.osacky.umbrella.data.api.model.RainPeriod;
import com.osacky.umbrella.data.api.model.WeatherCondition;
import com.osacky.umbrella.data.api.model.WeatherForecast;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;
import timber.log.Timber;

public class ProcessWeather implements Func1<WeatherForecastResult, List<RainPeriod>> {

    private static final ProcessWeather INSTANCE = new ProcessWeather();

    public static ProcessWeather getInstance() {
        return INSTANCE;
    }

    private ProcessWeather() {}

    @Override public List<RainPeriod> call(WeatherForecastResult weatherForecastResult) {
        DateTime oneDayFuture = new DateTime().plusDays(1);
        List<RainPeriod> rainPeriods = new ArrayList<>();
        RainPeriod lastPeriod = null;
        for (WeatherForecast forecast : weatherForecastResult.getList()) {
            DateTime dateTime = forecast.getDateTime();
            if (dateTime.isAfter(oneDayFuture)) {
                Timber.d("%s is after %s, exiting loop", dateTime, oneDayFuture);
                break;
            }
            Timber.i("Checking datetime %s", dateTime.toString(DateTimeFormat.shortDateTime()));
            WeatherCondition weather = forecast.getWeather();
            if (weather.isAnyRain()) {
                // if raining
                if (lastPeriod != null && lastPeriod.getCondition() == weather.getId()) {
                    // if current weather condition is the same as the last one
                    lastPeriod.updateEnd(dateTime.plusHours(3));
                } else {
                    // if current weather condition differs from the last one sent
                    lastPeriod = new RainPeriod(dateTime, weather.getId());
                    rainPeriods.add(lastPeriod);
                }
            } else {
                lastPeriod = null;
            }
        }
        Timber.i("Returning rain periods %s", rainPeriods);
        return rainPeriods;
    }
}
