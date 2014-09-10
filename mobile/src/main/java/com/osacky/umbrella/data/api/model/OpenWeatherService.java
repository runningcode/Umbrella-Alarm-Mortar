package com.osacky.umbrella.data.api.model;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface OpenWeatherService {
    @GET("/forecast")
    Observable<WeatherForecastResult> getWeatherForecast(
            @Query("lat") double latitude, @Query("lon") double longitude);
}
