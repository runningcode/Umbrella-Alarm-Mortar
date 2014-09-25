package com.osacky.umbrella.ui.test;


import android.location.Location;

import com.osacky.umbrella.actionbar.ActionBarOwner;
import com.osacky.umbrella.alarm.AlarmHelper;
import com.osacky.umbrella.data.api.weather.CurrentWeatherManager;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.annotations.TimePref;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;
import javax.inject.Provider;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class WeatherPresenterTest {

    @Inject CurrentWeatherManager mWeatherManager;
    @Inject ActionBarOwner mActionBarOwner;
    @Inject @TimePref IntPreference mTimePreference;
    @Inject Provider<Location> mLocationProvider;
    @Inject AlarmHelper mAlarmHelper;

    private WeatherScreen.Presenter presenter;

    @Before
    public void setUp() throws Exception {
        System.out.println("LocationProvider is " + mLocationProvider);

        presenter = new WeatherScreen.Presenter(null, mActionBarOwner, mWeatherManager, mTimePreference, mLocationProvider, mAlarmHelper);
    }

    @Test
    public void testStuff() throws Exception {
        Assertions.assertThat(presenter).isNotNull();

        presenter.getDefaultTime();
    }
}
