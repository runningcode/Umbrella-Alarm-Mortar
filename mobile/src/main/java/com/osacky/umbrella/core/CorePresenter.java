package com.osacky.umbrella.core;

import com.osacky.umbrella.UmbrellaModule;
import com.osacky.umbrella.core.util.FlowOwner;
import com.osacky.umbrella.ui.base.BaseTabScreen;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Flow;
import flow.Parcer;
import mortar.Blueprint;

public class CorePresenter implements Blueprint {

    private final String scopeName;

    /**
     * Required for a race condition cause by Android when a new scope is created
     * before the old one is destroyed
     * <p/>
     * https://github.com/square/mortar/issues/87#issuecomment-43849264
     */
    public CorePresenter(String scopeName) {
        this.scopeName = scopeName;
    }

    @Override public String getMortarScopeName() {
        return scopeName;
    }

    @Override public Object getDaggerModule() {
        return new Module();
    }

    @dagger.Module(
            injects = {
                    CoreView.class
            },
            addsTo = UmbrellaModule.class,
            library = true
    )
    public final class Module {
        public Module() {}

        @Provides
        Flow provideFlow(Presenter presenter) {
            return presenter.getFlow();
        }
    }

    @Singleton
    public static class Presenter extends FlowOwner<Blueprint, CoreView> {

        @Inject
        Presenter(Parcer<Object> flowParcer) {
            super(flowParcer);
        }

        @Override
        protected Blueprint getFirstScreen() {
            return new BaseTabScreen();
        }
    }
}
