package com.osacky.umbrella.ui.hourly;

import com.osacky.umbrella.data.api.model.Ly;

class TodayWeatherSummary {
    private final float mLowTemp;
    private final float mHighTemp;
    private final CharSequence mSummary;
    private final int mChanceOfRain;
    private final Ly mHourly;

    public TodayWeatherSummary(
            float lowTemp, float highTemp, CharSequence summary, int chanceOfRain, Ly hourly) {
        mLowTemp = lowTemp;
        mHighTemp = highTemp;
        mSummary = summary;
        mChanceOfRain = chanceOfRain;
        mHourly = hourly;
    }

    public float getLowTemp() {
        return mLowTemp;
    }

    public float getHighTemp() {
        return mHighTemp;
    }

    public CharSequence getSummary() {
        return mSummary;
    }

    public int getChanceOfRain() {
        return mChanceOfRain;
    }

    public Ly getHourly() {
        return mHourly;
    }
}
