package com.osacky.umbrella.ui.forecast;

import com.osacky.umbrella.data.api.model.Ly;

class ForecastWeatherSummary {
    private final CharSequence mSummary;
    private final Ly mDaily;

    public ForecastWeatherSummary(CharSequence summary, Ly daily) {
        mSummary = summary;
        mDaily = daily;
    }

    public CharSequence getSummary() {
        return mSummary;
    }

    public Ly getDaily() {
        return mDaily;
    }
}
