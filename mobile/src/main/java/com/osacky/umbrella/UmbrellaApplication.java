package com.osacky.umbrella;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.osacky.umbrella.core.CrashlyticsTree;
import com.osacky.umbrella.core.RollingTimberTree;
import com.osacky.umbrella.util.Utils;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.ObjectGraph;
import mortar.Mortar;
import mortar.MortarScope;
import timber.log.Timber;

public class UmbrellaApplication extends Application {

    @Inject protected RollingTimberTree mRollingTimberTree;

    protected MortarScope applicationScope;

    @Override
    public void onCreate() {
        super.onCreate();
        setup();
        buildObjectGraphAndInject();
        postSetup();
    }

    protected void setup() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());

            Utils.enableStrictMode();
        } else {
            Crashlytics.start(this);
            Crashlytics.setString("locale", Locale.getDefault().toString());
            Timber.plant(new CrashlyticsTree());
        }
    }

    protected void postSetup() {
        if (!BuildConfig.DEBUG) {
            Timber.plant(mRollingTimberTree);
        }
    }

    protected void buildObjectGraphAndInject() {
        long start = System.nanoTime();

        ObjectGraph objectGraph = ObjectGraph.create(Modules.list(this));
        objectGraph.inject(this);
        applicationScope = Mortar.createRootScope(BuildConfig.DEBUG, objectGraph);

        long diff = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        Timber.i("Global object graph creation took %dms", diff);
    }

    public void rebuildObjectGraphAndInject() {
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

    public ObjectGraph getObjectGraph() {
        return applicationScope.getObjectGraph();
    }
}
