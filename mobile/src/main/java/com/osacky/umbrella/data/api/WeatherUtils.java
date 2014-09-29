package com.osacky.umbrella.data.api;

import com.osacky.umbrella.data.api.model.Condition;

public class WeatherUtils {
    private WeatherUtils() {}

    private static final String RAIN = "rain";
    private static final String SLEET = "sleet";

    public static boolean isStringRain(String icon) {
        return RAIN.equalsIgnoreCase(icon) || SLEET.equalsIgnoreCase(icon);
    }

    public static boolean isConditionRain(Condition condition) {
        return isStringRain(condition.getIcon());
    }
}
