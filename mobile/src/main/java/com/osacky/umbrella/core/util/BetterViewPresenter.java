package com.osacky.umbrella.core.util;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;

import mortar.MortarScope;
import mortar.ViewPresenter;
import timber.log.Timber;

public class BetterViewPresenter<V extends View> extends ViewPresenter<V> {

    private final SparseArray<Parcelable> viewState;

    private boolean isViewStateRestored;

    public BetterViewPresenter(SparseArray<Parcelable> viewState) {
        this.viewState = viewState;
    }

    /**
     * Try restoring view state. It will safely no-op if state has already been restored
     */
    protected void restoreViewState() {
        Timber.i("restore view state %s", viewState != null);
        Timber.i("%s", viewState);
        if (viewState != null && !isViewStateRestored) {
            getView().restoreHierarchyState(viewState);
        }
    }

    @Override
    public void onLoad(Bundle savedInstanceState) {
        Timber.v("onLoad");
        super.onLoad(savedInstanceState);
        if (getView() == null) {
            throw new IllegalStateException(String.format("%s: getView() is null", getClass().getName()));
        }
    }

    @Override
    public void dropView(V view) {
        Timber.v("dropView");
        isViewStateRestored = false;
        super.dropView(view);
    }

    @Override
    protected void onSave(Bundle outState) {
        super.onSave(outState);
        Timber.v("onSave: %s", outState);
    }

    @Override
    protected void onEnterScope(MortarScope scope) {
        super.onEnterScope(scope);
        Timber.v("onEnterScope");

    }

    @Override
    protected void onExitScope() {
        super.onExitScope();
        Timber.v("onExitScope");
    }
}
