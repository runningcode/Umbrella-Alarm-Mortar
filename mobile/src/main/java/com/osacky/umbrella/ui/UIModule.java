package com.osacky.umbrella.ui;

import com.osacky.umbrella.MainActivity;
import com.osacky.umbrella.actionbar.ActionBarOwner;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = MainActivity.class,
        complete = false,
        library = true
)
public class UIModule {

    @Provides @Singleton
    ActionBarOwner provideActionBarOwner() {
        return new ActionBarOwner();
    }

    @Provides @Singleton AppContainer provideAppContainer() {
        return AppContainer.DEFAULT;
    }
}
