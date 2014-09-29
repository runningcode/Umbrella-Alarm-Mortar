package com.osacky.umbrella.data.api.model;

import org.joda.time.DateTime;

public class Condition {


    private long time;
    private String summary;
    private String icon;
    private long sunriseTime;
    private long sunsetTime;
    private float moonPhase;
    private float nearestStormDistance;
    private int nearestStormBearing;
    private float precipIntensity;
    private float precipIntensityMax;
    private float precipProbability;
    private String precipType;
    private float precipAccumulation;
    private float temperature;
    private float temperatureMin;
    private float temperatureMax;
    private float apparentTemperature;
    private float dewPoint;
    private float humidity;
    private float windSpeed;
    private float windBearing;
    private float visibility;
    private float cloudCover;
    private float pressure;
    private float ozone;

    public float getTemperatureMin() {
        return temperatureMin;
    }

    public float getTemperatureMax() {
        return temperatureMax;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getApparentTemperature() {
        return apparentTemperature;
    }

    public DateTime getDateTime() {
        return new DateTime(time * 1000);
    }

    public String getIcon() {
        return icon;
    }

    public float getPrecipIntensity() {
        return precipIntensity;
    }

    public int getPrecipProbability() {
        return (int) (precipProbability * 100);
    }

    public String getSummary() {
        return summary;
    }
}
