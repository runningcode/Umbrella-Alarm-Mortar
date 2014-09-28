package com.osacky.umbrella.data.api;

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

    public static final String PRODUCTION_API_URL = "https://api.forecast.io";

    @Provides @Singleton Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(PRODUCTION_API_URL);
    }

    @Provides @Singleton Client provideClient(OkHttpClient client) {
        return new OkClient(client);
    }

    @Provides @Singleton RestAdapter provideRestAdapter(Endpoint endpoint, Client client) {
        return new RestAdapter.Builder()
                .setClient(client)
                .setEndpoint(endpoint)
                .build();
    }

    @Provides @Singleton WeatherService provideWeatherService(RestAdapter restAdapter) {
        return restAdapter.create(WeatherService.class);
    }

    @Provides @Singleton
    ForecastWeatherManager provideCurrentWeatherManager(WeatherService service) {
        return new ForecastWeatherManager(service);

    }

}
