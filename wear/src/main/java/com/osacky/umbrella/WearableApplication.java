package com.osacky.umbrella;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import rx.Observable;
import timber.log.Timber;

public class WearableApplication extends Application {

    private WearableApplicationComponent component;

    @Override public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        this.component = Dagger_WearableApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.injectApplication(this);
    }

    public static WearableApplication get(Context context) {
        return (WearableApplication) context.getApplicationContext();
    }

    WearableApplicationComponent getComponent() {
        return component;
    }
}
