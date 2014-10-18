package com.osacky.umbrella.data.manager;

import com.osacky.umbrella.data.api.WeatherService;

import java.util.HashMap;
import java.util.Map;

import hugo.weaving.DebugLog;
import rx.Observable;

public abstract class BaseManager<Result, ARG> {

    private final Map<ARG, Observable<Result>> mRequestCache = new HashMap<>();
    private final WeatherService mApi;

    /**
     * Construct a new Fetcher instance
     * @param api the api to make calls on
     */
    public BaseManager(WeatherService api) {
        mApi = api;
    }

    protected WeatherService getApi() {
        return mApi;
    }

    protected void putInRequestCache(ARG key, Observable<Result> value) {
        mRequestCache.put(key, value);
    }

    protected Observable<Result> getFromRequestCache(ARG key) {
        return mRequestCache.get(key);
    }

    protected void removeFromRequestCache(ARG key) {
        mRequestCache.remove(key);
    }
}
