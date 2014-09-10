package com.osacky.umbrella;

final class Modules {
    static Object[] list(UmbrellaApplication app) {
        return new Object[] {
                new UmbrellaModule(app),
                new DebugUmbrellaModule()
        };
    }

    private Modules() {
        // No instances.
    }
}
