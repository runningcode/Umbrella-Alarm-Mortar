package com.osacky.umbrella.ui.now;

import com.osacky.umbrella.data.api.model.Ly;

class NowWeatherSummary {
    private final float mCurrentTemp;
    private final float mFeelsLike;
    private final CharSequence mSummary;
    private final Ly mMinutely;

    public NowWeatherSummary(
            float currentTemp, float feelsLike, CharSequence summary, Ly minutely) {
        mCurrentTemp = currentTemp;
        mFeelsLike = feelsLike;
        mSummary = summary;
        mMinutely = minutely;
    }

    public float getCurrentTemp() {
        return mCurrentTemp;
    }

    public float getFeelsLike() {
        return mFeelsLike;
    }

    public CharSequence getSummary() {
        return mSummary;
    }

    public Ly getMinutely() {
        return mMinutely;
    }
}
