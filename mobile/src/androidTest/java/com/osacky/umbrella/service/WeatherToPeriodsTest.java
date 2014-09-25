package com.osacky.umbrella.service;

import com.google.gson.Gson;
import com.osacky.umbrella.data.api.MockWeatherService;
import com.osacky.umbrella.data.api.model.RainPeriodResult;
import com.osacky.umbrella.data.api.model.WeatherForecast;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class WeatherToPeriodsTest {

    private WeatherToPeriods mWeatherToPeriods;
    private List<WeatherForecast> emptyList = Collections.emptyList();
    private List<WeatherForecast> nonEmptyList = new ArrayList<WeatherForecast>();

    @Before
    public void setUp() throws Exception {
        mWeatherToPeriods = new WeatherToPeriods();
    }

    @Test
    public void testNullWeather() throws Exception {
        RainPeriodResult call = mWeatherToPeriods.call(null);
        Assertions.assertThat(call).isNull();
    }

    @Test
    public void testEmptyWeatherList() throws Exception {
        WeatherForecastResult mock = Mockito.mock(WeatherForecastResult.class);
        Mockito.when(mock.getList()).thenReturn(emptyList);
        RainPeriodResult call = mWeatherToPeriods.call(mock);
        Assertions.assertThat(call).isNull();
    }

    @Test
    public void testWeatherGetsResult() throws Exception {
        WeatherForecastResult result = new Gson().fromJson(MockWeatherService
                .JSON_SEATTLE_FORECAST, WeatherForecastResult.class);
        RainPeriodResult call = mWeatherToPeriods.call(result);
        Assertions.assertThat(call).isNotNull();
    }
}
