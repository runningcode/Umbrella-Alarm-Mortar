package com.osacky.umbrella;

import android.location.Location;

import com.osacky.umbrella.ui.test.WeatherPresenterTest;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = UmbrellaModule.class,
        injects = {
                TestUmbrellaApplication.class,
                MainActivityTest.class,
                WeatherPresenterTest.class
        },
        overrides = true,
        library = true
)
public class TestModule {
    @Provides
    Location provideLocation() {
        return new Location("?");
    }
}
