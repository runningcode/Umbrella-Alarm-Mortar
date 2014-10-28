package com.osacky.umbrella.core;

import android.app.Activity;

import com.osacky.umbrella.UmbrellaModule;
import com.osacky.umbrella.core.util.FlowOwner;
import com.osacky.umbrella.core.util.Screen;
import com.osacky.umbrella.ui.base.BaseTabScreen;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Flow;
import flow.Parcer;
import mortar.Blueprint;

public class CorePresenter implements Blueprint {

    private final String scopeName;

    public CorePresenter(Activity activity) {
        scopeName = activity.getLocalClassName() + "-task-" + activity.getTaskId();
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
        @Provides
        Flow provideFlow(Presenter presenter) {
            return presenter.getFlow();
        }
    }

    @Singleton
    public static class Presenter extends FlowOwner<Screen, CoreView> {

        @Inject
        Presenter(Parcer<Object> flowParcer) {
            super(flowParcer);
        }

        @Override
        protected Screen getFirstScreen() {
            return new BaseTabScreen();
        }
    }
}
