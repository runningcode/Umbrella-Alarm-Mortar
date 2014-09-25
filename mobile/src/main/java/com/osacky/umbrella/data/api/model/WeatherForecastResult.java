package com.osacky.umbrella.data.api.model;

import java.util.List;

public class WeatherForecastResult {
    private String cod;
    private float message;
    private City city;
    private int cnt;
    private List<WeatherForecast> list;

    public List<WeatherForecast> getList() {
        return list;
    }

    public String getCityName() {
        return city.getName();
    }

    public String getCode() {
        return cod;
    }

    @Override public String toString() {
        return "WeatherForecastResult{" +
                "cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                ", list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherForecastResult that = (WeatherForecastResult) o;

        return cnt == that.cnt && Float.compare(that.message, message) == 0 && cod.equals(that
                .cod) && list.equals(that.list);
    }

    @Override
    public int hashCode() {
        int result = cod.hashCode();
        result = 31 * result + (message != +0.0f ? Float.floatToIntBits(message) : 0);
        result = 31 * result + cnt;
        result = 31 * result + list.hashCode();
        return result;
    }
}
