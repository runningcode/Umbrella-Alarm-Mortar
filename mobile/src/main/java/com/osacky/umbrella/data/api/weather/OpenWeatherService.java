package com.osacky.umbrella.data.api.weather;

import com.osacky.umbrella.data.api.model.WeatherForecastResult;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;
import rx.Observable;

import static com.osacky.umbrella.data.api.ApiUtils.CACHE_CONTROL_HEADER_VALUE;
import static com.osacky.umbrella.data.api.ApiUtils.CACHE_CONTROL_HEADER_NAME;

public interface OpenWeatherService {
    @GET("/forecast")
    Observable<WeatherForecastResult> getWeatherForecast(
            @Query("lat") double latitude, @Query("lon") double longitude);

    @Headers(CACHE_CONTROL_HEADER_NAME + ": " + CACHE_CONTROL_HEADER_VALUE)
    @GET("/forecast")
    Observable<WeatherForecastResult> getWeatherForecastFromCache(
            @Query("lat") double latitude, @Query("lon") double longitude);
}
