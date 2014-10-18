package com.osacky.umbrella.ui.test;


import android.location.Location;

import com.osacky.umbrella.actionbar.ActionBarOwner;
import com.osacky.umbrella.alarm.DailyAlarmHelper;
import com.osacky.umbrella.data.api.ForecastWeatherManager;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.annotations.TimePref;
import com.osacky.umbrella.service.WeatherToSummary;
import com.osacky.umbrella.ui.base.BaseTabScreen;
import com.osacky.umbrella.ui.now.NowScreen;
import com.osacky.umbrella.ui.now.WeatherToNow;

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

    @Inject Provider<Location> mLocationProvider;
    @Inject WeatherToNow mWeatherToNow;
    @Inject BaseTabScreen.Presenter mBasePresenter;

    private NowScreen.Presenter presenter;

    @Before
    public void setUp() throws Exception {
        System.out.println("LocationProvider is " + mLocationProvider);

        presenter = new NowScreen.Presenter(null, mBasePresenter, mWeatherToNow);
    }

    @Test
    public void testStuff() throws Exception {
        Assertions.assertThat(presenter).isNotNull();
    }
}
