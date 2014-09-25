package com.osacky.umbrella.core.util;

import android.os.Parcelable;
import android.util.SparseArray;

import mortar.Blueprint;

public interface StateBlueprint extends Blueprint {
    public void setViewState(SparseArray<Parcelable> viewState);
}
