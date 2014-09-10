package com.osacky.umbrella.data.api.model;

public class WeatherForecast {

    private WeatherCondition[] weather;

    public WeatherCondition getWeather() {
        return weather[0];
    }
}
