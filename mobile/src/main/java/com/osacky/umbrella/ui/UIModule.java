package com.osacky.umbrella.ui;

import com.osacky.umbrella.MainActivity;
import com.osacky.umbrella.core.presenters.ConnectedPresenter;
import com.osacky.umbrella.core.presenters.ConnectionCallbacksRegistrar;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = MainActivity.class,
        complete = false,
        library = true
)
public class UIModule {

    @Provides @Singleton AppContainer provideAppContainer() {
        return AppContainer.DEFAULT;
    }

    @Provides @Singleton
    ConnectedPresenter provideConnectedPresenter() {
        return new ConnectedPresenter();
    }

    @Provides @Singleton
    ConnectionCallbacksRegistrar provideConnectedCallbacksRegistrar(ConnectedPresenter connectedPresenter) {
        return connectedPresenter;
    }
}
