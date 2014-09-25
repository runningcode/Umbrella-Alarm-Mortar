package com.osacky.umbrella.core.util;

public abstract class TransitionScreen {

    private int[] transitions;

    public void setTransitions(int[] transitions) {
        this.transitions = transitions;
    }

    public int[] getTransitions() {
        return transitions;
    }
}
