package com.osacky.umbrella;

import dagger.Component;

@Component(dependencies = WearableApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void injectActivity(MainActivity activity);
}
