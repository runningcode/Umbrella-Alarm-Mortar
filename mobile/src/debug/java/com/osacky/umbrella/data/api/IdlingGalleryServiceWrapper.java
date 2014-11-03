package com.osacky.umbrella.data.api;

import com.google.android.apps.common.testing.ui.espresso.IdlingResource;
import com.osacky.umbrella.data.api.model.WeatherResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.http.Path;
import rx.Observable;
import rx.functions.Action0;

/**
 * GalleryService wrapper to be used when testing
 * with Espresso. See:
 * https://code.google.com/p/android-test-kit/wiki/EspressoSamples#Using_registerIdlingResource_to_synchronize_with_custom_resource
 */
@Singleton
public class IdlingGalleryServiceWrapper implements WeatherService, IdlingResource {

    @Inject WeatherService api;

    private final AtomicInteger counter;

    private final List<ResourceCallback> callbacks;

    @Inject public IdlingGalleryServiceWrapper(WeatherService api) {
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
    public Observable<WeatherResult> getWeather(@Path("latitude") double latitude, @Path("longitude") double longitude) {
        counter.incrementAndGet();
        return api.getWeather(latitude, longitude).finallyDo(new IdlingAction());
    }

    @Override
    public Observable<WeatherResult> getWeatherFromCache(@Path("latitude") double latitude, @Path("longitude") double longitude) {
        counter.incrementAndGet();
        return api.getWeatherFromCache(latitude, longitude).finallyDo(new IdlingAction());
    }

    private class IdlingAction implements Action0 {
        @Override public void call() {
            counter.decrementAndGet();
            notifyIdle();
        }
    }
}
