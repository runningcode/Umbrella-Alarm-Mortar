package com.osacky.umbrella.data.api;

import com.google.android.apps.common.testing.ui.espresso.IdlingResource;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;
import com.osacky.umbrella.data.api.weather.OpenWeatherService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.http.Query;
import rx.Observable;
import rx.functions.Action0;

/**
 * GalleryService wrapper to be used when testing
 * with Espresso. See:
 * https://code.google.com/p/android-test-kit/wiki/EspressoSamples#Using_registerIdlingResource_to_synchronize_with_custom_resource
 */
@Singleton
public class IdlingGalleryServiceWrapper implements OpenWeatherService, IdlingResource {

    @Inject OpenWeatherService api;

    private final AtomicInteger counter;

    private final List<ResourceCallback> callbacks;

    @Inject public IdlingGalleryServiceWrapper(OpenWeatherService api) {
        this.api = api;
        this.callbacks = new ArrayList<>();
        this.counter = new AtomicInteger(0);
    }

    @Override public String getName() {
        return this.getClass().getName() + hashCode();
    }

    @Override public boolean isIdleNow() {
        return counter.get() == 0;
    }

    @Override public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        callbacks.add(resourceCallback);
    }

    private void notifyIdle() {
        if (counter.get() == 0) {
            for (ResourceCallback cb : callbacks) {
                cb.onTransitionToIdle();
            }
        }
    }

    @Override
    public Observable<WeatherForecastResult> getWeatherForecast(
            @Query("lat") double latitude, @Query("lon") double longitude) {
        counter.incrementAndGet();
        return api.getWeatherForecast(latitude, longitude).finallyDo(new IdlingAction());
    }

    @Override
    public Observable<WeatherForecastResult> getWeatherForecastFromCache(
            @Query("lat") double latitude, @Query("lon") double longitude) {
        counter.incrementAndGet();
        return api.getWeatherForecastFromCache(latitude, longitude).finallyDo(new IdlingAction());
    }

    private class IdlingAction implements Action0 {
        @Override public void call() {
            counter.decrementAndGet();
            notifyIdle();
        }
    }
}
