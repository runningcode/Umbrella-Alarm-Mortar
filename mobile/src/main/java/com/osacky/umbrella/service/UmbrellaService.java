package com.osacky.umbrella.service;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.osacky.umbrella.R;
import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.data.api.ForecastWeatherManager;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.ObjectGraph;
import retrofit.RetrofitError;
import rx.RetrofitObserver;

public class UmbrellaService extends IntentService {

    @Inject NotificationManagerCompat mNotificationManager;
    @Inject Provider<Location> mLocationProvider;
    @Inject ForecastWeatherManager mWeatherManager;
    @Inject Provider<NotificationCompat.Builder> mBuilderProvider;
    @Inject
    WeatherToSummary mWeatherToSummary;
    @Inject PeriodsToNotification mPeriodsToNotification;
    @Inject ErrorToNotification mErrorToNotification;

    private static final int NOTIF_WEATHER_ID = 0;
    private static final int NOTIF_LOCATION_ERROR_ID = 1;
    private static final int NOTIF_RETROFIT_ERROR_ID = 2;

    private ObjectGraph serviceGraph;

    public UmbrellaService() {
        super(UmbrellaService.class.getSimpleName());
    }

    @Override public void onCreate() {
        super.onCreate();
        serviceGraph = UmbrellaApplication.get(this).getObjectGraph().plus(new ServiceModule(this));
        serviceGraph.inject(this);
    }

    @Override public void onDestroy() {
        serviceGraph = null;
        super.onDestroy();
    }

    @Override protected void onHandleIntent(Intent intent) {
        mNotificationManager.cancelAll();
        Location lastLocation = mLocationProvider.get();
        if (lastLocation == null) {
            String contentText = getString(R.string.error_null_location);
            Notification notification = mBuilderProvider.get()
                    .setTicker(contentText)
                    .setContentTitle(getString(R.string.error))
                    .setContentText(contentText)
                    .addAction(android.R.drawable.ic_media_rew, "Retry", null)
                    .build();
            mNotificationManager.notify(NOTIF_LOCATION_ERROR_ID,notification);
            return;
        }

        mWeatherManager.get(lastLocation.getLatitude(), lastLocation.getLongitude())
                .map(mWeatherToSummary)
                .map(mPeriodsToNotification)
                .subscribe(new RetrofitObserver<Notification>() {
                    @Override public void onRetrofitError(RetrofitError e) {
                        Notification notification = mErrorToNotification.call(e);
                        mNotificationManager.notify(NOTIF_RETROFIT_ERROR_ID, notification);
                    }

                    @Override
                    public void onNext(Notification notification) {
                        if (notification == null) return;
                        mNotificationManager.notify(NOTIF_WEATHER_ID, notification);
                    }
                });
    }
}
