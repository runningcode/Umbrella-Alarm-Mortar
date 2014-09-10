package com.osacky.umbrella.data.api;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.RequestInterceptor;

@Singleton
public final class ApiHeaders implements RequestInterceptor {

  private final String authorizationValue;

  @Inject
  public ApiHeaders(@ApiKey String clientId) {
    authorizationValue = clientId;
  }

  @Override public void intercept(RequestFacade request) {
    request.addHeader("x-api-key", authorizationValue);
  }
}
