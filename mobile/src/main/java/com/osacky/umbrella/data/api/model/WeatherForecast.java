package com.osacky.umbrella.data.api.model;

import org.joda.time.DateTime;

import java.util.Arrays;

public class WeatherForecast {

    private long dt;
    private WeatherCondition[] weather;

    public WeatherCondition getWeather() {
        return weather[0];
    }

    public DateTime getDateTime() {
        return new DateTime(dt * 1000);
    }

    @Override public String toString() {
        return "WeatherForecast{" +
                "dt=" + dt +
                ", weather=" + weather[0] +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherForecast forecast = (WeatherForecast) o;

        return dt == forecast.dt && Arrays.equals(weather, forecast.weather);
    }

    @Override
    public int hashCode() {
        int result = (int) (dt ^ (dt >>> 32));
        result = 31 * result + (weather != null ? Arrays.hashCode(weather) : 0);
        return result;
    }
}
