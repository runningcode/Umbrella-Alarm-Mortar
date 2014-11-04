package com.osacky.umbrella.data.api;

import android.location.Geocoder;
import android.support.annotation.Nullable;

import com.crashlytics.android.Crashlytics;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WeatherGeoCoder {
    private final Geocoder mGeocoder;

    @Inject
    public WeatherGeoCoder(Geocoder geocoder) {
        mGeocoder = geocoder;
    }

    @Nullable
    public String getCityForLocation(float latitude, float longitude) {
        try {
            return mGeocoder.getFromLocation(latitude, longitude, 1).get(0).getLocality();
        } catch (IndexOutOfBoundsException e) {
            return null;
        } catch (IOException e) {
            Crashlytics.logException(e);
            return null;
        }
    }


}
