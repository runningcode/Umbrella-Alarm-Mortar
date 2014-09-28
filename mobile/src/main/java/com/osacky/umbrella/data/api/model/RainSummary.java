package com.osacky.umbrella.data.api.model;

public class RainSummary {
    private final CharSequence mSummary;
    private final CharSequence mCityName;
    private final int mChanceOfRain;

    public RainSummary(CharSequence summary, CharSequence cityName, int chanceOfRain) {
        mSummary = summary;
        mCityName = cityName;
        mChanceOfRain = chanceOfRain;
    }

    public CharSequence getSummary() {
        return mSummary;
    }

    public CharSequence getCityName() {
        return mCityName;
    }

    public int getChanceOfRain() {
        return mChanceOfRain;
    }

    @Override public String toString() {
        return "RainSummary{" +
                "mSummary=" + mSummary +
                ", mCityName=" + mCityName +
                ", mChanceOfRain=" + mChanceOfRain +
                '}';
    }
}
