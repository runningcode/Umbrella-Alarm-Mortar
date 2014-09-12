package com.osacky.umbrella.ui;

import com.osacky.umbrella.MainActivity;
import com.osacky.umbrella.actionbar.ActionBarOwner;
import com.osacky.umbrella.mortar.ActivityPresenter;
import com.osacky.umbrella.mortar.ActivityResultPresenter;
import com.osacky.umbrella.mortar.ActivityResultRegistrar;
import com.osacky.umbrella.mortar.PauseAndResumePresenter;
import com.osacky.umbrella.mortar.PauseAndResumeRegistrar;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = MainActivity.class,
        complete = false,
        library = true
)
public class UIModule {

    @Provides @Singleton ActionBarOwner provideActionBarOwner() {
        return new ActionBarOwner();
    }

    @Provides @Singleton ActivityPresenter provideActivityPresenter() {
        return new ActivityPresenter();
    }

    @Provides @Singleton PauseAndResumePresenter providePauseAndResumePresenter() {
        return new PauseAndResumePresenter();
    }

    @Provides @Singleton
    PauseAndResumeRegistrar providePauseAndResumeRegistrar(PauseAndResumePresenter presenter) {
        return presenter;
    }

    @Provides @Singleton ActivityResultPresenter provideActivityResultPresenter() {
        return new ActivityResultPresenter();
    }

    @Provides @Singleton
    ActivityResultRegistrar provideActivityResultRegistrar(ActivityResultPresenter presenter) {
        return presenter;
    }

    @Provides @Singleton AppContainer provideAppContainer() {
        return AppContainer.DEFAULT;
    }
}
