package com.osacky.umbrella.data;

import static com.osacky.umbrella.data.api.ApiModule.PRODUCTION_API_URL;

public enum ApiEndpoints {
    PRODUCTION("Production", PRODUCTION_API_URL),
    // STAGING("Staging", "https://api.staging.imgur.com/3/"),
    MOCK_MODE("Mock Mode", "mock://"),
    CUSTOM("Custom", null);

    public final String name;
    public final String url;

  ApiEndpoints(String name, String url) {
    this.name = name;
    this.url = url;
  }

  @Override public String toString() {
    return name;
  }

  public static ApiEndpoints from(String endpoint) {
    for (ApiEndpoints value : values()) {
      if (value.url != null && value.url.equals(endpoint)) {
        return value;
      }
    }
    return CUSTOM;
  }

  public static boolean isMockMode(String endpoint) {
    return from(endpoint) == MOCK_MODE;
  }
}
