package com.osacky.umbrella.core.presenters;

import com.google.android.gms.common.api.GoogleApiClient;

public interface HasGoogleApiClient extends HasScope {
    GoogleApiClient getGoogleApiClient();

}
