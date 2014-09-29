package com.osacky.umbrella.data;

import android.app.AlarmManager;
import android.content.SharedPreferences;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationManagerCompat;

import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.data.api.ApiModule;
import com.osacky.umbrella.data.api.ApiUtils;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.annotations.TimePref;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

import static android.content.Context.ALARM_SERVICE;
import static android.content.Context.LOCATION_SERVICE;
import static android.location.LocationManager.PASSIVE_PROVIDER;

@Module(
        includes = ApiModule.class,
        complete = false,
        library = true
)
public class DataModule {

    @Provides @Singleton SharedPreferences provideSharedPreferences(UmbrellaApplication app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides @Singleton OkHttpClient provideOkHttpClient(UmbrellaApplication app) {
        return createOkHttpClient(app);
    }

    @Provides @Singleton Picasso providePicasso(UmbrellaApplication app, OkHttpClient client) {
        return new Picasso.Builder(app)
                .downloader(new OkHttpDownloader(client))
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Timber.e(exception, "Failed to load image: %s", uri);
                    }
                })
                .build();
    }

    @Provides @Singleton @TimePref
    IntPreference provideDefaultTime(SharedPreferences sharedPreferences) {
        return new IntPreference(sharedPreferences, "pref_time", 32400000);
    }

    @Provides @Singleton
    LocationManager provideLocationManager(UmbrellaApplication application) {
        return (LocationManager) application.getSystemService(LOCATION_SERVICE);
    }

    @Provides @Singleton
    NotificationManagerCompat provideNotificationManager(UmbrellaApplication application) {
        return NotificationManagerCompat.from(application);
    }

    @Provides @Singleton
    AlarmManager provideAlarmManager(UmbrellaApplication application) {
        return (AlarmManager) application.getSystemService(ALARM_SERVICE);
    }

    @Provides
    Location provideLocation(LocationManager locationManager) {
        return locationManager.getLastKnownLocation(PASSIVE_PROVIDER);
    }

    @Provides
    Geocoder provideGeocoder(UmbrellaApplication application) {
        return new Geocoder(application);
    }

    static OkHttpClient createOkHttpClient(UmbrellaApplication app) {
        OkHttpClient client = new OkHttpClient();

        // Install an HTTP cache in the application cache directory.
        try {
            File cacheDir = ApiUtils.createDefaultCacheDir(app);
            Cache cache = new Cache(cacheDir, ApiUtils.calculateDiskCacheSize(cacheDir));
            client.setCache(cache);
        } catch (IOException e) {
            Timber.e(e, "Unable to install disk cache.");
        }
        return client;
    }
}
