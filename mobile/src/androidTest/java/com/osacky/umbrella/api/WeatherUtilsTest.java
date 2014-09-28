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
        assertThat(WeatherUtils.isRain("Rain")).isTrue();
        assertThat(WeatherUtils.isRain("rain")).isTrue();
        assertThat(WeatherUtils.isRain("RAIN")).isTrue();
        assertThat(WeatherUtils.isRain("sleet")).isTrue();
    }

    @Test public void testIsNotRain() throws Exception {
        assertThat(WeatherUtils.isRain("clear-night")).isFalse();
        assertThat(WeatherUtils.isRain("cloudy")).isFalse();
        assertThat(WeatherUtils.isRain("thunderstorm")).isFalse();
        assertThat(WeatherUtils.isRain("tornado")).isFalse();
    }
}
