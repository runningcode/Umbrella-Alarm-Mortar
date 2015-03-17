package com.osacky.umbrella.data.api.model;

import android.support.annotation.Nullable;

public class WeatherResult {
    private float latitude;
    private float longitude;
    private String timezone;
    private int offset;
    private Condition currently;
    private Ly minutely;
    private Ly hourly;
    private Ly daily;

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public Condition getCurrently() {
        return currently;
    }

    /**
     * This can be null sometimes (outside the US)
     */
    @Nullable
    public Ly getMinutely() {
        return minutely;
    }

    public Ly getHourly() {
        return hourly;
    }

    public Ly getDaily() {
        return daily;
    }
}
