package com.osacky.umbrella.core;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.osacky.umbrella.core.util.CanShowScreen;
import com.osacky.umbrella.core.util.Path;
import com.osacky.umbrella.core.util.ScreenScoper;

import javax.inject.Inject;

import flow.Flow;
import mortar.Mortar;

public class CoreView extends FrameLayout implements CanShowScreen<Path> {

    @Inject CorePresenter.Presenter presenter;

    private final ScreenScoper<Path> screenMaestro;

    public CoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Mortar.inject(context, this);
        screenMaestro = new ScreenScoper<>(context, this);
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
    public void showScreen(Path path, Path oldPath, Flow.Direction direction) {
        screenMaestro.showScreen(path, oldPath, direction);
    }
}
