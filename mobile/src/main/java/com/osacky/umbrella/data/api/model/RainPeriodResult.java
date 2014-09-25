package com.osacky.umbrella.data.api.model;

import java.util.List;

public class RainPeriodResult {

    private final List<RainPeriod> mRainPeriods;
    private final CharSequence mCityName;
    private final String mCode;

    public RainPeriodResult(
            List<RainPeriod> rainPeriods,
            CharSequence cityName,
            String code) {
        mRainPeriods = rainPeriods;
        mCityName = cityName;
        mCode = code;
    }

    public List<RainPeriod> getRainPeriods() {
        return mRainPeriods;
    }

    public CharSequence getCityName() {
        return mCityName;
    }

    public String getCode() {
        return mCode;
    }
}
