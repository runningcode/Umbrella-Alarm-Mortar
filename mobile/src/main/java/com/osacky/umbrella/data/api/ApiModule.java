package com.osacky.umbrella.data.api;

import android.support.v4.util.LruCache;

import com.osacky.umbrella.data.api.model.OpenWeatherService;
import com.osacky.umbrella.data.api.weather.CurrentWeatherManager;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;

@Module(
        library = true,
        complete = false
)
public class ApiModule {

    public static final String PRODUCTION_API_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "223d662502eca4f5904881633eca5dce";

    @Provides @Singleton @ApiKey String provideClientId() {
        return API_KEY;
    }

    @Provides @Singleton Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(PRODUCTION_API_URL);
    }

    @Provides @Singleton Client provideClient(OkHttpClient client) {
        return new OkClient(client);
    }

    @Provides @Singleton RestAdapter provideRestAdapter(Endpoint endpoint, Client client, ApiHeaders headers) {
        return new RestAdapter.Builder() //
                .setClient(client) //
                .setEndpoint(endpoint) //
                .setRequestInterceptor(headers) //
                .build();
    }

    @Provides @Singleton
    OpenWeatherService provideWeatherService(RestAdapter restAdapter) {
        return restAdapter.create(OpenWeatherService.class);
    }

    @Provides @Singleton
    CurrentWeatherManager provideCurrentWeatherManager(OpenWeatherService service) {
        return new CurrentWeatherManager(service);

    }

}
