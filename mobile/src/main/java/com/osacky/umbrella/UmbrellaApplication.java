package com.osacky.umbrella;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.osacky.umbrella.core.CrashlyticsTree;

import java.util.concurrent.TimeUnit;

import dagger.ObjectGraph;
import mortar.Mortar;
import mortar.MortarScope;
import timber.log.Timber;

public class UmbrellaApplication extends Application {
    private MortarScope applicationScope;

    @Override
    public void onCreate() {
        super.onCreate();
        Crashlytics.start(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashlyticsTree());
        }
        buildObjectGraphAndInject();
    }

    private void buildObjectGraphAndInject() {
        long start = System.nanoTime();

        ObjectGraph objectGraph = ObjectGraph.create(Modules.list(this));
        objectGraph.inject(this);
        applicationScope = Mortar.createRootScope(BuildConfig.DEBUG, objectGraph);

        long diff = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        Timber.i("Global object graph creation took %sms", diff);
    }

    public void rebuildOjectGraphAndInject() {
        Mortar.destroyRootScope(applicationScope);
        buildObjectGraphAndInject();
    }

    @Override
    public Object getSystemService(String name) {
        if (Mortar.isScopeSystemService(name)) {
            return applicationScope;
        }
        return super.getSystemService(name);
    }

    public static UmbrellaApplication get(Context context) {
        return (UmbrellaApplication) context.getApplicationContext();
    }
}
