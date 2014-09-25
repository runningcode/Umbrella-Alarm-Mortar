package com.osacky.umbrella.data.manager;

import com.osacky.umbrella.data.api.weather.OpenWeatherService;

import java.util.HashMap;
import java.util.Map;

import hugo.weaving.DebugLog;
import rx.Observable;

public abstract class BaseManager<Result, ARG> {

    private final Map<ARG, Observable<Result>> mRequestCache = new HashMap<>();
    private final OpenWeatherService mApi;

    /**
     * Construct a new Fetcher instance
     * @param api the api to make calls on
     */
    public BaseManager(OpenWeatherService api) {
        mApi = api;
    }

    protected OpenWeatherService getApi() {
        return mApi;
    }

    @DebugLog
    protected void putInRequestCache(ARG key, Observable<Result> value) {
        mRequestCache.put(key, value);
    }

    @DebugLog
    protected Observable<Result> getFromRequestCache(ARG key) {
        return mRequestCache.get(key);
    }

    @DebugLog
    protected void removeFromRequestCache(ARG key) {
        mRequestCache.remove(key);
    }
}
