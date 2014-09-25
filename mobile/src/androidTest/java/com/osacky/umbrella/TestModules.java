package com.osacky.umbrella;

final class TestModules {
    static Object[] list(UmbrellaApplication app) {
        return new Object[] {
                new UmbrellaModule(app),
                new DebugUmbrellaModule(),
                new TestModule()

        };
    }

    private TestModules() {
        // No instances.
    }
}
