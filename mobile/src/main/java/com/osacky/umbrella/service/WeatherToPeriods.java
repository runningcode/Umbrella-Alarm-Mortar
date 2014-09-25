package com.osacky.umbrella.service;

import com.osacky.umbrella.data.api.model.RainPeriod;
import com.osacky.umbrella.data.api.model.RainPeriodResult;
import com.osacky.umbrella.data.api.model.WeatherCondition;
import com.osacky.umbrella.data.api.model.WeatherForecast;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.functions.Func1;
import timber.log.Timber;

@Singleton
public class WeatherToPeriods implements Func1<WeatherForecastResult, RainPeriodResult> {

    @Inject
    public WeatherToPeriods() {}

    @Override public RainPeriodResult call(WeatherForecastResult weatherForecastResult) {
        if (weatherForecastResult == null || weatherForecastResult.getList().isEmpty()) {
            return null;
        }
        DateTime oneDayFuture = new DateTime().plusDays(1);
        DateTime threeHoursPast = new DateTime().minusHours(3);
        List<RainPeriod> rainPeriods = new ArrayList<>();
        RainPeriod lastPeriod = null;
        for (WeatherForecast forecast : weatherForecastResult.getList()) {
            DateTime dateTime = forecast.getDateTime();
            if (dateTime.isAfter(oneDayFuture)) {
                Timber.d("%s is after %s, exiting loop", dateTime, oneDayFuture);
                break;
            }
            if (dateTime.isBefore(threeHoursPast)) {
                Timber.d("%s is before %s, exiting loop", dateTime, threeHoursPast);
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
        return new RainPeriodResult(
                rainPeriods,
                weatherForecastResult.getCityName(),
                weatherForecastResult.getCode());
    }
}
