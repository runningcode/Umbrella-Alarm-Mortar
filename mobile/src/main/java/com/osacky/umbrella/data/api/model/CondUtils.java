package com.osacky.umbrella.data.api.model;

import android.support.annotation.StringRes;

import com.osacky.umbrella.R;

public class CondUtils {
    private CondUtils() {}

    public static @StringRes int getStringResIdForCondCode(int conditionCode) {
        switch (conditionCode) {
            case 200:
                return R.string.cond_200_thunderstorm_light_rain;
            case 201:
                return R.string.cond_201_thunderstorm_rain;
            case 202:
                return R.string.cond_202_thunderstorm_heavy_rain;
            case 210:
                return R.string.cond_210_thunderstorm_light;
            case 211:
                return R.string.cond_211_thunderstorm;
            case 212:
                return R.string.cond_212_thunderstorm_heavy;
            case 221:
                return R.string.cond_221_thunderstorm_ragged;
            case 230:
                return R.string.cond_230_thunderstorm_light_drizzle;
            case 231:
                return R.string.cond_231_thunderstorm_drizzle;
            case 232:
                return R.string.cond_232_thunderstorm_heavy_drizzle;
            case 300:
                return R.string.cond_300_drizzle_light;
            case 301:
                return R.string.cond_301_drizzle;
            case 302:
                return R.string.cond_302_drizzle_heavy;
            case 310:
                return R.string.cond_310_drizzle_rain_light;
            case 311:
                return R.string.cond_311_drizzle_rain;
            case 312:
                return R.string.cond_312_drizzle_rain_heavy;
            case 313:
                return R.string.cond_313_drizzle_shower_rain;
            case 314:
                return R.string.cond_314_drizzle_shower_rain_heavy;
            case 321:
                return R.string.cond_321_drizzle_shower;
            case 500:
                return R.string.cond_500_light_rain;
            case 501:
                return R.string.cond_501_moderate_rain;
            case 502:
                return R.string.cond_502_heavy_rain;
            case 503:
                return R.string.cond_503_rain_very_heavy;
            case 504:
                return R.string.cond_504_extreme_rain;
            case 511:
                return R.string.cond_511_freezing_rain;
            case 520:
                return R.string.cond_520_light_showers;
            case 521:
                return R.string.cond_521_showers;
            case 522:
                return R.string.cond_522_heavy;
            case 531:
                return R.string.cond_531_heavy;
            default:
                throw new IllegalArgumentException("Don't have condition code " + conditionCode);
        }
    }
}
