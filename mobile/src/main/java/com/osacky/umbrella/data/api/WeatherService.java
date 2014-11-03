package com.osacky.umbrella.data.api;

import com.osacky.umbrella.data.api.model.WeatherResult;

import org.joda.time.DateTimeConstants;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import rx.Observable;

public interface WeatherService {

    static final int MAX_STALE = DateTimeConstants.SECONDS_PER_WEEK * 4;
    static final String API_KEY = "3f25235a185fb0ec1f9b5962d8b5cc2c";
    static final String CACHE_CONTROL_HEADER_NAME = "Cache-Control";
    static final String CACHE_CONTROL_HEADER_VALUE =
            "public, only-if-cached, max-stale=" + MAX_STALE;

    @GET("/forecast/" + API_KEY + "/{latitude},{longitude}")
    Observable<WeatherResult> getWeather(
            @Path("latitude") double latitude,
            @Path("longitude") double longitude);

    @Headers(CACHE_CONTROL_HEADER_NAME + ": " + CACHE_CONTROL_HEADER_VALUE)
    @GET("/forecast/" + API_KEY + "/{latitude},{longitude}")
    Observable<WeatherResult> getWeatherFromCache(
            @Path("latitude") double latitude,
            @Path("longitude") double longitude);
}
