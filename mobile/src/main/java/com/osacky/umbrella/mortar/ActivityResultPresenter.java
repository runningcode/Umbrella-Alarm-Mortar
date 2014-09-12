package com.osacky.umbrella.mortar;

import android.content.Intent;

import java.util.HashSet;
import java.util.Set;

import mortar.Mortar;
import mortar.MortarScope;
import mortar.Presenter;
import mortar.Scoped;

public class ActivityResultPresenter extends Presenter<HasScope>
        implements ActivityResultRegistrar {

    private final Set<Registration> registrations = new HashSet<>();

    public ActivityResultPresenter() {
    }

    @Override public void register(MortarScope scope, ActivityResultInterface listener) {
        Registration registration = new Registration(listener);
        scope.register(registration);

        registrations.add(registration);
    }

    @Override protected MortarScope extractScope(HasScope view) {
        return Mortar.getScope(view.getMortarContext());
    }

    @Override protected void onExitScope() {
        registrations.clear();
        super.onExitScope();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (Registration registration : registrations) {
            registration.registrant.onActivityResult(requestCode, resultCode, data);
        }
    }

    private class Registration implements Scoped {
        final ActivityResultInterface registrant;

        private Registration(ActivityResultInterface registrant) {
            this.registrant = registrant;
        }

        @Override public void onEnterScope(MortarScope scope) {
        }

        @Override public void onExitScope() {
            registrations.remove(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Registration that = (Registration) o;

            return registrant.equals(that.registrant);
        }

        @Override
        public int hashCode() {
            return registrant.hashCode();
        }
    }
}
