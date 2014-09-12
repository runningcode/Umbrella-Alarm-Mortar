package com.osacky.umbrella.mortar;

import mortar.MortarScope;

public interface ActivityResultRegistrar {
    void register(MortarScope scope, ActivityResultInterface listener);
}
