package com.osacky.umbrella;

final class Modules {
    static Object[] list(UmbrellaApplication app) {
        return new Object[] {
                new UmbrellaModule(app)
        };
    }

    private Modules() {
        // No instances.
    }
}
