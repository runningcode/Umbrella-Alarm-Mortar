package com.osacky.umbrella.ui.now;

import static com.jjoe64.graphview.GraphView.GraphViewData;

class NowWeatherSummary {
    private final float mCurrentTemp;
    private final float mFeelsLike;
    private final CharSequence mSummary;
    private final GraphViewData[] mData;
    private final boolean mWillRain;

    public NowWeatherSummary(
            float currentTemp, float feelsLike, CharSequence summary, GraphViewData[] data,
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

    public GraphViewData[] getData() {
        return mData;
    }

    public boolean isWillRain() {
        return mWillRain;
    }
}
