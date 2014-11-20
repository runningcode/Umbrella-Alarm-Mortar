package com.osacky.umbrella;

import javax.inject.Singleton;

import dagger.Component;
import rx.Observable;

@Component(
        modules = ApplicationModule.class
)
@Singleton
interface WearableApplicationComponent {
    void injectApplication(WearableApplication application);
    void injectListenerService(DataLayerListenerService service);

    // expose these to child-components
    @Temp IntPreference provideTempPref();
    @Temp Observable<Integer> provideIntObservable();
    @Description StringPreference provideStringPreference();
    @Description Observable<String> provideStringObservable();
}
