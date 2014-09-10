package com.osacky.umbrella.core;

import com.crashlytics.android.Crashlytics;

import timber.log.Timber;

public class CrashlyticsTree extends Timber.HollowTree {
    @Override public void e(String message, Object... args) {
        Crashlytics.log(message);
    }

    @Override public void e(Throwable t, String message, Object... args) {
        Crashlytics.logException(t);
    }
}
