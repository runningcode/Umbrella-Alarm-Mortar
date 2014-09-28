package com.osacky.umbrella.data.api;

import android.content.SharedPreferences;

import com.osacky.umbrella.data.annotations.ApiEndpoint;
import com.osacky.umbrella.data.annotations.IsMockMode;
import com.osacky.umbrella.data.prefs.StringPreference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;
import retrofit.android.AndroidMockValuePersistence;

@Module(
        complete = false,
        library = true,
        overrides = true
)
public final class DebugApiModule {

    @Provides @Singleton Endpoint provideEndpoint(@ApiEndpoint StringPreference apiEndpoint) {
        return Endpoints.newFixedEndpoint(apiEndpoint.get());
    }

    @Provides @Singleton
    MockRestAdapter provideMockRestAdapter(RestAdapter restAdapter, SharedPreferences preferences) {
        MockRestAdapter mockRestAdapter = MockRestAdapter.from(restAdapter);
        AndroidMockValuePersistence.install(mockRestAdapter, preferences);
        return mockRestAdapter;
    }

    @Provides
    @Singleton WeatherService provideGalleryService(IdlingGalleryServiceWrapper idlingWrapper) {
        return idlingWrapper;
    }

    @Provides
    @Singleton IdlingGalleryServiceWrapper provideIdlingGalleryServiceWrapper(
            RestAdapter restAdapter,
            MockRestAdapter mockRestAdapter,
            @IsMockMode boolean isMockMode,
            MockWeatherService mockService) {
        return new IdlingGalleryServiceWrapper((
                isMockMode
                        ? mockRestAdapter.create(WeatherService.class, mockService)
                        : restAdapter.create(WeatherService.class)
        ));
    }
}
