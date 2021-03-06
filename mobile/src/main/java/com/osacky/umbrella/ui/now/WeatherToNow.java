package com.osacky.umbrella.ui.now;

import com.osacky.umbrella.data.api.model.Condition;
import com.osacky.umbrella.data.api.model.WeatherResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import lecho.lib.hellocharts.model.PointValue;
import rx.functions.Func1;

@Singleton
public class WeatherToNow implements Func1<WeatherResult, NowWeatherSummary> {

    @Inject WeatherToNow() {}

    @Override public NowWeatherSummary call(WeatherResult weatherResult) {
        if (weatherResult == null) {
            return null;
        }
        boolean willRain = false;
        List<Condition> data = weatherResult.getMinutely() != null ? weatherResult.getMinutely().getData() : Collections.<Condition>emptyList();
        List<PointValue> pointValues = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            float intensity = data.get(i).getPrecipIntensity();
            if (intensity > 0) {
                willRain = true;
            }
            pointValues.add(new PointValue(i, intensity));
        }

        return new NowWeatherSummary(
                weatherResult.getCurrently().getTemperature(),
                weatherResult.getCurrently().getApparentTemperature(),
                weatherResult.getMinutely() != null ? weatherResult.getMinutely().getSummary() : null,
                pointValues,
                willRain);
    }
}
