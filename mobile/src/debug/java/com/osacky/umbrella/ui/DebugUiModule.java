package com.osacky.umbrella.ui;

import com.osacky.umbrella.ui.debug.DebugAppContainer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = DebugAppContainer.class,
        complete = false,
        library = true,
        overrides = true
)
public class DebugUiModule {
    @Provides @Singleton AppContainer provideAppContainer(DebugAppContainer debugAppContainer) {
        return debugAppContainer;
    }
}
