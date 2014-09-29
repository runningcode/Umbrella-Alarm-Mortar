package com.osacky.umbrella.api;

import com.osacky.umbrella.data.api.WeatherUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class WeatherUtilsTest {

    @Test public void testIsRain() throws Exception {
        assertThat(WeatherUtils.isStringRain("Rain")).isTrue();
        assertThat(WeatherUtils.isStringRain("rain")).isTrue();
        assertThat(WeatherUtils.isStringRain("RAIN")).isTrue();
        assertThat(WeatherUtils.isStringRain("sleet")).isTrue();
    }

    @Test public void testIsNotRain() throws Exception {
        assertThat(WeatherUtils.isStringRain("clear-night")).isFalse();
        assertThat(WeatherUtils.isStringRain("cloudy")).isFalse();
        assertThat(WeatherUtils.isStringRain("thunderstorm")).isFalse();
        assertThat(WeatherUtils.isStringRain("tornado")).isFalse();
    }
}
