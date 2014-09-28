package com.osacky.umbrella.ui.test;


import android.location.Location;

import com.osacky.umbrella.actionbar.ActionBarOwner;
import com.osacky.umbrella.alarm.AlarmHelper;
import com.osacky.umbrella.data.api.ForecastWeatherManager;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.annotations.TimePref;
import com.osacky.umbrella.service.WeatherToSummary;
import com.osacky.umbrella.ui.now.NowScreen;

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

    @Inject ForecastWeatherManager mWeatherManager;
    @Inject ActionBarOwner mActionBarOwner;
    @Inject @TimePref IntPreference mTimePreference;
    @Inject Provider<Location> mLocationProvider;
    @Inject AlarmHelper mAlarmHelper;
    @Inject
    WeatherToSummary mWeatherToSummary;

    private NowScreen.Presenter presenter;

    @Before
    public void setUp() throws Exception {
        System.out.println("LocationProvider is " + mLocationProvider);

        presenter = new NowScreen.Presenter(null, mActionBarOwner, mWeatherManager, mTimePreference, mLocationProvider, mAlarmHelper, mWeatherToSummary);
    }

    @Test
    public void testStuff() throws Exception {
        Assertions.assertThat(presenter).isNotNull();

        presenter.getDefaultTime();
    }
}
