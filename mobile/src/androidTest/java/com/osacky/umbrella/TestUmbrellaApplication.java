package com.osacky.umbrella;

import org.robolectric.TestLifecycleApplication;
import org.robolectric.shadows.ShadowLog;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import dagger.ObjectGraph;
import mortar.Mortar;
import timber.log.Timber;

public class TestUmbrellaApplication extends UmbrellaApplication implements TestLifecycleApplication {

    @Override protected void setup() {
        Timber.plant(new Timber.DebugTree());
        ShadowLog.stream = System.out;
    }

    @Override protected void buildObjectGraphAndInject() {
        long start = System.nanoTime();

        ObjectGraph objectGraph = ObjectGraph.create(TestModules.list(this));
        objectGraph.inject(this);
        applicationScope = Mortar.createRootScope(BuildConfig.DEBUG, objectGraph);

        long diff = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        Timber.i("Global object graph creation took %dms", diff);
    }

    @Override public void beforeTest(Method method) {
        Timber.i("before test");
    }

    @Override public void prepareTest(Object o) {
        Timber.i("prepare test");
    }

    @Override public void afterTest(Method method) {
        Timber.i("after test");
    }
}
