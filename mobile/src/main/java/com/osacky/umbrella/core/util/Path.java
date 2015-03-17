package com.osacky.umbrella.core.util;

import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.util.ObjectUtils;

import mortar.Blueprint;

public abstract class Path implements Blueprint {

    @Override public boolean equals(Object o) {
        return o != null && o instanceof Path && this.getName().equals(((Path) o).getName());
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
}
