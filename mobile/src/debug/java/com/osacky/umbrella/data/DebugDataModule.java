package com.osacky.umbrella.data;

import android.content.SharedPreferences;

import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.data.annotations.AnimationSpeed;
import com.osacky.umbrella.data.annotations.ApiEndpoint;
import com.osacky.umbrella.data.annotations.IsMockMode;
import com.osacky.umbrella.data.annotations.NetworkProxy;
import com.osacky.umbrella.data.annotations.PicassoDebugging;
import com.osacky.umbrella.data.annotations.RetrofitLogLevel;
import com.osacky.umbrella.data.annotations.SeenDebugDrawer;
import com.osacky.umbrella.data.api.DebugApiModule;
import com.osacky.umbrella.data.prefs.BooleanPreference;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.StringPreference;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;

@Module(
        includes = DebugApiModule.class,
        complete = false,
        library = true,
        overrides = true,
        injects = {
                IdlingDownloaderWrapper.class
        }
)
public final class DebugDataModule {
    private static final String DEFAULT_LOG_LEVEL = RestAdapter.LogLevel.NONE.name();
    private static final int DEFAULT_ANIMATION_SPEED = 1; // 1x (normal) speed.
    private static final boolean DEFAULT_PICASSO_DEBUGGING = false; // Debug indicators displayed
    private static final boolean DEFAULT_SEEN_DEBUG_DRAWER = false; // Show debug drawer first time.

    @Provides @Singleton OkHttpClient provideOkHttpClient(UmbrellaApplication app) {
        OkHttpClient client = DataModule.createOkHttpClient(app);
        client.setSslSocketFactory(createBadSslSocketFactory());
        return client;
    }

    @Provides @Singleton @ApiEndpoint StringPreference provideEndpointPreference(
            SharedPreferences preferences) {
        return new StringPreference(preferences, "debug_endpoint", ApiEndpoints.MOCK_MODE.url);
    }

    @Provides @Singleton @IsMockMode boolean provideIsMockMode(
            @ApiEndpoint StringPreference endpoint) {
        return ApiEndpoints.isMockMode(endpoint.get());
    }

    @Provides @Singleton @NetworkProxy StringPreference provideNetworkProxy(
            SharedPreferences preferences) {
        return new StringPreference(preferences, "debug_network_proxy");
    }

    @Provides @Singleton @AnimationSpeed IntPreference provideAnimationSpeed(
            SharedPreferences preferences) {
        return new IntPreference(preferences, "debug_animation_speed", DEFAULT_ANIMATION_SPEED);
    }

    @Provides @Singleton @RetrofitLogLevel StringPreference provideRetrofitLogLevel(
            SharedPreferences preferences) {
        return new StringPreference(preferences, "debug_retrofit_log_level", DEFAULT_LOG_LEVEL);
    }

    @Provides @Singleton @PicassoDebugging BooleanPreference providePicassoDebugging(
            SharedPreferences preferences) {
        return new BooleanPreference(preferences, "debug_picasso_debugging",
                DEFAULT_PICASSO_DEBUGGING);
    }

    @Provides @Singleton @SeenDebugDrawer BooleanPreference provideSeenDebugDrawer(
            SharedPreferences preferences) {
        return new BooleanPreference(preferences, "debug_seen_debug_drawer",
                DEFAULT_SEEN_DEBUG_DRAWER);
    }

    @Provides @Singleton Picasso providePicasso(
            IdlingDownloaderWrapper downloaderWrapper, UmbrellaApplication app) {
        return new Picasso.Builder(app)
                .downloader(downloaderWrapper)
                .build();
    }

    @Provides @Singleton Downloader provideDownloader(IdlingDownloaderWrapper idlingWrapper) {
        return idlingWrapper;
    }

    @Provides @Singleton IdlingDownloaderWrapper provideIdlingDownloaderWrapper(
            MockRestAdapter mockRestAdapter,
            UmbrellaApplication app,
            OkHttpClient client,
            @IsMockMode boolean isMockMode) {
        return new IdlingDownloaderWrapper(
                (isMockMode)
                        ? new MockDownloader(mockRestAdapter, app.getAssets())
                        : new OkHttpDownloader(client)
        );
    }

    private static SSLSocketFactory createBadSslSocketFactory() {
        try {
            // Construct SSLSocketFactory that accepts any cert.
            SSLContext context = SSLContext.getInstance("TLS");
            TrustManager permissive = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            context.init(null, new TrustManager[]{permissive}, null);
            return context.getSocketFactory();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
