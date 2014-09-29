package com.osacky.umbrella.ui.now;

import com.echo.holographlibrary.Line;

class NowWeatherSummary {
    private final float mCurrentTemp;
    private final float mFeelsLike;
    private final CharSequence mSummary;
    private final Line mLine;

    public NowWeatherSummary(
            float currentTemp, float feelsLike, CharSequence summary, Line line) {
        mCurrentTemp = currentTemp;
        mFeelsLike = feelsLike;
        mSummary = summary;
        mLine = line;
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

    public Line getLine() {
        return mLine;
    }
}
