package com.osacky.umbrella.core.util;

import android.support.annotation.AnimRes;

public abstract class TransitionScreen extends Screen {

    private @AnimRes int[] transitions;

    public void setTransitions(@AnimRes int[] transitions) {
        this.transitions = transitions;
    }

    @AnimRes
    public int[] getTransitions() {
        return transitions;
    }
}
