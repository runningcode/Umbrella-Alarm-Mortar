package com.osacky.umbrella.ui.now;

import java.util.List;

import lecho.lib.hellocharts.model.PointValue;

class NowWeatherSummary {
    private final float mCurrentTemp;
    private final float mFeelsLike;
    private final CharSequence mSummary;
    private final List<PointValue> mData;
    private final boolean mWillRain;

    public NowWeatherSummary(
            float currentTemp, float feelsLike, CharSequence summary, List<PointValue> data,
            boolean willRain) {
        mCurrentTemp = currentTemp;
        mFeelsLike = feelsLike;
        mSummary = summary;
        mData = data;
        mWillRain = willRain;
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

    public List<PointValue> getData() {
        return mData;
    }

    public boolean isWillRain() {
        return mWillRain;
    }
}
