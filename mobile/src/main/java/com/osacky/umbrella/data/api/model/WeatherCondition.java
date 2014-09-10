package com.osacky.umbrella.data.api.model;

public class WeatherCondition {
    private int id;
    private String main;
    private String description;
    private String icon;

    public String getDescription() {
        return description;
    }

    private static final String THUNDERSTORM = "Thunderstorm";
    private static final String RAIN = "Rain";
    private static final String DRIZZLE = "Drizzle";
    private static final String SNOW = "Snow";
    private static final String ATMOSPHERE = "Atmosphere";
    private static final String CLOUDS = "Clouds";
    private static final String EXTREME = "Extreme";
    private static final String ADDITIONAL = "Additional";

}
