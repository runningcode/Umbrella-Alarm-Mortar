package com.osacky.umbrella.service;

import com.google.gson.Gson;
import com.osacky.umbrella.data.api.WeatherGeoCoder;
import com.osacky.umbrella.data.api.model.Ly;
import com.osacky.umbrella.data.api.model.RainSummary;
import com.osacky.umbrella.data.api.model.WeatherResult;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.osacky.umbrella.data.api.MockWeatherService.JSON_SEATTLE_FORECAST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class WeatherToSummaryTest {

    @Mock WeatherGeoCoder mWeatherGeoCoder;
    @Mock Ly mLy;
    @Mock WeatherResult mWeatherResult;
    private WeatherToSummary mWeatherToSummary;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        mWeatherToSummary = new WeatherToSummary(mWeatherGeoCoder);
    }

    @Test
    public void testNullWeather() throws Exception {
        RainSummary summary = mWeatherToSummary.call(null);
        assertThat(summary).isNull();
    }

    @Test
    public void testNonRainCondition() throws Exception {
        when(mWeatherResult.getHourly()).thenReturn(mLy);
        when(mLy.getIcon()).thenReturn("cloudy");
        RainSummary summary = mWeatherToSummary.call(mWeatherResult);
        assertThat(summary).isNull();
    }

    @Test
    public void testWeatherGetsResult() throws Exception {
        when(mWeatherGeoCoder.getCityForLocation(anyFloat(), anyFloat())).thenReturn("Seattle");
        WeatherResult result = new Gson().fromJson(JSON_SEATTLE_FORECAST, WeatherResult.class);
        RainSummary summary = mWeatherToSummary.call(result);
        assertThat(summary).isNotNull();
        assertThat(summary.getChanceOfRain()).isEqualTo(9);
        assertThat(summary.getCityName()).isEqualTo("Seattle");
        assertThat(summary.getSummary()).isEqualTo("Rain starting this evening, continuing until tomorrow morning.");
    }
}
