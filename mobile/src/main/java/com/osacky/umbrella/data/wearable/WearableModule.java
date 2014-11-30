package com.osacky.umbrella.data.wearable;

import com.osacky.umbrella.data.api.model.WeatherResult;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;
import rx.subjects.BehaviorSubject;

@Module(injects = DataLayerListenerService.class)
public class WearableModule {
    @Provides @Singleton BehaviorSubject<WeatherResult> provideWeatherResultSubject() {
        return BehaviorSubject.create();
    }

    @Provides @Singleton
    Observable<WeatherResult> provideWeatherResultObservable(BehaviorSubject<WeatherResult> subject) {
        return subject;
    }
}
