package com.osacky.umbrella;

import dagger.Component;

@Component(dependencies = WearableApplicationComponent.class, modules = DataListenerModule.class)
public interface DataListenerComponent {
    void injectListener(DataLayerListenerService listenerService);
}
