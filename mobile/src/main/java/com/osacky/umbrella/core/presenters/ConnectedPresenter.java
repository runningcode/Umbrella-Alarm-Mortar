package com.osacky.umbrella.core.presenters;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashSet;
import java.util.Set;

import mortar.MortarScope;
import mortar.Presenter;
import mortar.Scoped;

/**
 * Presenter to be registered by the {@link PauseAndResumeActivity}.
 * copied from
 * http://stackoverflow.com/questions/21927990/mortar-flow-with-third-party-libraries-hooked-to
 * -activity-lifecycle
 */
public class ConnectedPresenter extends Presenter<HasGoogleApiClient> implements
        ConnectionCallbacksRegistrar, GoogleApiClient.ConnectionCallbacks {

    public ConnectedPresenter() {
    }

    private final Set<Registration> registrations = new HashSet<>();

    @Override protected MortarScope extractScope(HasGoogleApiClient view) {
        return view.getScope();
    }

    @Override public void onExitScope() {
        registrations.clear();
    }

    @Override public void register(MortarScope scope, GoogleApiClient.ConnectionCallbacks listener) {
        Registration registration = new Registration(listener);
        scope.register(registration);
    }

    @Override public void onConnected(Bundle bundle) {
        for (Registration registration : registrations) {
            registration.registrant.onConnected(bundle);
        }
    }

    @Override public void onConnectionSuspended(int i) {
        for (Registration registration : registrations) {
            registration.registrant.onConnectionSuspended(i);
        }
    }

    @Nullable
    public GoogleApiClient getGoogleApiClient() {
        if (getView() != null) {
            return getView().getGoogleApiClient();
        }
        return null;
    }

    private class Registration implements Scoped {
        final GoogleApiClient.ConnectionCallbacks registrant;

        private Registration(GoogleApiClient.ConnectionCallbacks registrant) {
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
