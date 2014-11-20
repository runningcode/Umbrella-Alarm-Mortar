package com.osacky.umbrella.core.presenters;

import com.google.android.gms.common.api.GoogleApiClient;

import mortar.MortarScope;

public interface ConnectionCallbacksRegistrar {
    void register(MortarScope scope, GoogleApiClient.ConnectionCallbacks listener);
}
