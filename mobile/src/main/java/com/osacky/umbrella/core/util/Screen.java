package com.osacky.umbrella.core.util;

import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.util.ObjectUtils;

import mortar.Blueprint;

public abstract class Screen implements Blueprint {

    protected SparseArray<Parcelable> mViewState;

    @Override public boolean equals(Object o) {
        return o != null && o instanceof Screen && this.getName().equals(((Screen) o).getName());
    }

    @Override public int hashCode() {
        return getName().hashCode();
    }

    @Override public String getMortarScopeName() {
        return getName();
    }

    public String getName() {
        return ObjectUtils.getClass(this).getName();
    }

    protected SparseArray<Parcelable> getViewState() {
        return mViewState;
    }

    public void setViewState(SparseArray<Parcelable> viewState) {
        this.mViewState = viewState;
    }
}
