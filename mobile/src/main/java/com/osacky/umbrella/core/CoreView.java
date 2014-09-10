package com.osacky.umbrella.core;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.osacky.umbrella.core.util.CanShowScreen;
import com.osacky.umbrella.core.util.ScreenConductor;

import javax.inject.Inject;

import flow.Flow;
import mortar.Blueprint;
import mortar.Mortar;

public class CoreView extends FrameLayout implements CanShowScreen<Blueprint> {

    @Inject CorePresenter.Presenter presenter;

    private final ScreenConductor<Blueprint> screenMaestro;

    public CoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Mortar.inject(context, this);
        screenMaestro = new ScreenConductor<>(context, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        presenter.takeView(this);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        presenter.dropView(this);
    }

    public Flow getFlow() {
        return presenter.getFlow();
    }

    @Override
    public void showScreen(Blueprint screen, Blueprint oldScreen, Flow.Direction direction) {
        screenMaestro.showScreen(screen, oldScreen, direction);
    }
}
