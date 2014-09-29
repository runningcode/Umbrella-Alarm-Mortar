package com.osacky.umbrella.ui.now;

import static com.jjoe64.graphview.GraphView.GraphViewData;

class NowWeatherSummary {
    private final float mCurrentTemp;
    private final float mFeelsLike;
    private final CharSequence mSummary;
    private final GraphViewData[] mData;

    public NowWeatherSummary(
            float currentTemp, float feelsLike, CharSequence summary, GraphViewData[] data) {
        mCurrentTemp = currentTemp;
        mFeelsLike = feelsLike;
        mSummary = summary;
        mData = data;
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
}
