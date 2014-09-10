package com.osacky.umbrella.data.manager;

import android.support.annotation.NonNull;

import com.osacky.umbrella.data.api.model.OpenWeatherService;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.observables.ConnectableObservable;

public abstract class DataManager<T, ARG> extends BaseManager<T, ARG> {

    public DataManager(OpenWeatherService api) {
        super(api);
    }

    // Does this need to be thread safe?
    @SafeVarargs
    public final Observable<T> get(final ARG key, ARG... args) {
        // if we are already requesting an object, return the the in-flight request
        final Observable<T> immediateReturn = getFromRequestCache(key);
        if (immediateReturn != null) {
            return immediateReturn;
        }
        final ConnectableObservable<T> observable = Observable.merge(
                fetchFromResponseCache(key, args).onExceptionResumeNext(Observable.<T>empty()),
                // TODO only retry network errors
                fetchFromInternet(key, args)
                        .onExceptionResumeNext(fetchFromInternet(key, args)
                                .delaySubscription(500, TimeUnit.MILLISECONDS)))
                .distinct()
                .doOnTerminate(new Action0() {
                    @Override public void call() {
                        removeFromRequestCache(key);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .replay(1);
        observable.connect();
        putInRequestCache(key, observable);
        return observable;
    }

    @SuppressWarnings("unchecked") @NonNull
    protected abstract Observable<T> fetchFromResponseCache(ARG key, ARG... args);

    @SuppressWarnings("unchecked") @NonNull
    protected abstract Observable<T> fetchFromInternet(ARG key, ARG... args);
}
