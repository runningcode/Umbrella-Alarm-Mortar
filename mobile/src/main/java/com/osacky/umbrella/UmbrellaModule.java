package com.osacky.umbrella;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.osacky.umbrella.core.util.GsonParcer;
import com.osacky.umbrella.data.DataModule;
import com.osacky.umbrella.ui.UIModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import flow.Parcer;

@Module(
        includes = {
                UIModule.class,
                DataModule.class
        },
        injects = UmbrellaApplication.class,
        library = true
)
public class UmbrellaModule {

    private final UmbrellaApplication mApplication;

    public UmbrellaModule(UmbrellaApplication app) {
        mApplication = app;
    }

    @Provides @Singleton
    UmbrellaApplication provideApplication() {
        return mApplication;
    }

    @Provides @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides @Singleton
    Parcer<Object> provideParcer(Gson gson) {
        return new GsonParcer<>(gson);
    }
}
