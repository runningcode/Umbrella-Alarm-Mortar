package com.osacky.umbrella.data.manager;

import com.osacky.umbrella.data.api.model.OpenWeatherService;

import java.util.HashMap;
import java.util.Map;

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
