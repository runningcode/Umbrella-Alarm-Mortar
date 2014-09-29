package com.osacky.umbrella.ui.now;

import com.osacky.umbrella.data.api.model.Condition;
import com.osacky.umbrella.data.api.model.WeatherResult;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.functions.Func1;

import static com.jjoe64.graphview.GraphView.GraphViewData;

@Singleton
public class WeatherToNow implements Func1<WeatherResult, NowWeatherSummary> {

    @Inject WeatherToNow() {}

    @Override public NowWeatherSummary call(WeatherResult weatherResult) {
        if (weatherResult == null) {
            return null;
        }
        List<Condition> data = weatherResult.getMinutely().getData();
        GraphViewData[] graphViewData = new GraphViewData[data.size()];
        for (int i = 0; i < data.size(); i++) {
            Condition condition = data.get(i);
            GraphViewData dataPoint = new GraphViewData(i, condition.getPrecipIntensity());
            graphViewData[i] = dataPoint;
        }

        return new NowWeatherSummary(
                weatherResult.getCurrently().getTemperature(),
                weatherResult.getCurrently().getApparentTemperature(),
                weatherResult.getMinutely().getSummary(),
                graphViewData);
    }
}
