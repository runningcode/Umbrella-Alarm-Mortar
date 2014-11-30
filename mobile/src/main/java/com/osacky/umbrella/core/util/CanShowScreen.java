package com.osacky.umbrella.core.util;

import flow.Flow;

public interface CanShowScreen<S extends Path> {
    void showScreen(S screen, S oldScreen, Flow.Direction direction);
}

