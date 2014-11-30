package com.osacky.umbrella.core.util;

import android.support.annotation.AnimRes;

import com.osacky.umbrella.R;

public abstract class TransitionScreen extends Path {

    private static final int[] DEFAULT_TRANSITION = new int[] {
            R.anim.empty, R.anim.empty, R.anim.empty, R.anim.empty
    };

    private @AnimRes int[] transitions;

    public void setTransitions(@AnimRes int[] transitions) {
        this.transitions = transitions;
    }

    @AnimRes
    public int[] getTransitions() {
        if (transitions == null) {
            return DEFAULT_TRANSITION;
        } else {
            return transitions;
        }
    }
}
