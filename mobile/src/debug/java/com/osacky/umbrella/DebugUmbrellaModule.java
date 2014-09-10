package com.osacky.umbrella;

import com.osacky.umbrella.data.DebugDataModule;
import com.osacky.umbrella.ui.DebugUiModule;

import dagger.Module;

@Module(
    addsTo = UmbrellaModule.class,
    includes = {
        DebugUiModule.class,
        DebugDataModule.class
    },
    overrides = true
)
public final class DebugUmbrellaModule {
}
