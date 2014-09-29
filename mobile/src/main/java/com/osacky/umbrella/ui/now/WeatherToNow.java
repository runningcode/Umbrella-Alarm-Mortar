package com.osacky.umbrella.ui.now;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LinePoint;
import com.osacky.umbrella.data.api.model.Condition;
import com.osacky.umbrella.data.api.model.WeatherResult;

import java.util.List;

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

        Line l = new Line();
        l.setUsingDips(true);
        l.setShowingPoints(false);
        List<Condition> data = weatherResult.getMinutely().getData();
        for (int i = 0; i < data.size(); i++) {
            Condition condition = data.get(i);
            LinePoint p = new LinePoint();
            p.setX(i);
            p.setY(condition.getPrecipIntensity());
            l.addPoint(p);
        }

        return new NowWeatherSummary(
                weatherResult.getCurrently().getTemperature(),
                weatherResult.getCurrently().getApparentTemperature(),
                weatherResult.getMinutely().getSummary(),
                l);
    }
}
