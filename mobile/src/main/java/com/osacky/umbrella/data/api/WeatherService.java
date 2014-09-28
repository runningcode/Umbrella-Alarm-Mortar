package com.osacky.umbrella.data.api;

import com.osacky.umbrella.data.api.model.WeatherResult;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface WeatherService {

    static final String API_KEY = "3f25235a185fb0ec1f9b5962d8b5cc2c";

    @GET("/forecast/" + API_KEY + "/{latitude},{longitude}")
    Observable<WeatherResult> getWeather(
            @Path("latitude") double latitude,
            @Path("longitude") double longitude);
}
