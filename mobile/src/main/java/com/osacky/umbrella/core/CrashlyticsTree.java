package com.osacky.umbrella.core;

import com.crashlytics.android.Crashlytics;

import timber.log.Timber;

public class CrashlyticsTree extends Timber.HollowTree {

    private void logMessage(String message, Object... args) {
        Crashlytics.log(String.format(message, args));
    }

    @Override
    public void e(String message, Object... args) {
        logMessage("ERROR: " + message, args);
    }

    @Override
    public void e(Throwable throwable, String message, Object... args) {
        logMessage("ERROR: " + message, args);
        Crashlytics.logException(throwable);
    }

    @Override
    public void i(String message, Object[] args) {
        logMessage(message, args);
    }

    @Override
    public void i(Throwable throwable, String message, Object[] args) {
        logMessage(message, args);
    }

    @Override
    public void w(String message, Object[] args) {
        logMessage("WARN: " + message, args);
    }

    @Override
    public void w(Throwable throwable, String message, Object... args) {
        logMessage("WARN: " + message, args);
    }
}
