package com.osacky.umbrella.data.api;

public class WeatherUtils {
    private WeatherUtils() {}

    private static final String RAIN = "rain";
    private static final String SLEET = "sleet";

    public static boolean isRain(String icon) {
        return RAIN.equalsIgnoreCase(icon) || SLEET.equalsIgnoreCase(icon);
    }
}
