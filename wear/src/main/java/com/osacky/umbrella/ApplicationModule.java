package com.osacky.umbrella;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

@Module
final class ApplicationModule {
    private final Application application;

    ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides @Singleton Application application() {
        return application;
    }

    @Provides @Singleton
    SharedPreferences provideSharedPref(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides @Singleton @Temp IntPreference provideTempPref(SharedPreferences preferences) {
        return new IntPreference(preferences, "temp_pref");
    }

    @Provides @Singleton @Temp Observable<Integer> provideTemp(@Temp IntPreference pref) {
        return pref.observe();
    }

    @Provides @Singleton @Description StringPreference provideDescPreference(SharedPreferences preferences) {
        return new StringPreference(preferences, "desc_pref");
    }

    @Provides @Singleton @Description Observable<String> provideDescription(@Description StringPreference pref) {
        return pref.observe();
    }
}
