package com.osacky.umbrella.data.api.model;

import java.util.List;

public class WeatherForecastResult {
    private String cod;
    private float message;
    private int cnt;
    private List<WeatherForecast> list;

    public List<WeatherForecast> getList() {
        return list;
    }
}
