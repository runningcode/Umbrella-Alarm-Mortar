package com.osacky.umbrella.data.manager;

import android.support.annotation.Nullable;

import rx.Observable;

public class RxUtils {

    private RxUtils() {}

    public static <T> Observable<T> wrap(@Nullable T object) {
        if (object == null) {
            return Observable.empty();
        } else {
            return Observable.just(object);
        }
    }
}

