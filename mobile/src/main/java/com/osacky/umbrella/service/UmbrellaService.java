package com.osacky.umbrella.service;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.osacky.umbrella.R;
import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.data.api.weather.CurrentWeatherManager;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.ObjectGraph;
import retrofit.RetrofitError;
import rx.RetrofitObserver;

public class UmbrellaService extends IntentService {

    @Inject NotificationManagerCompat mNotificationManager;
    @Inject Provider<Location> mLocationProvider;
    @Inject CurrentWeatherManager mWeatherManager;
    @Inject Provider<NotificationCompat.Builder> mBuilderProvider;

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
        Location lastLocation = mLocationProvider.get();
        if (lastLocation == null) {
            mNotificationManager.notify(NOTIF_LOCATION_ERROR_ID, createErrorNotification
                    (getString(R.string.error_null_location)));
            return;
        }

        mWeatherManager.get(lastLocation.getLatitude(), lastLocation.getLongitude())
                .map(ProcessWeather.getInstance())
                .map(new ProcessPeriods(this))
                .subscribe(new RetrofitObserver<CharSequence>() {
                    @Override public void onRetrofitError(RetrofitError e) {
                        mNotificationManager
                                .notify(NOTIF_RETROFIT_ERROR_ID,
                                        createRetrofitErrorNotification(e));
                    }

                    @Override
                    public void onNext(CharSequence notificationText) {
                        if (notificationText == null) return;
                        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();
                        Notification notification = mBuilderProvider.get()
                                .setTicker(notificationText)
                                .setContentTitle(getString(R.string.notif_title))
                                .setContentText(notificationText)
                                .setSmallIcon(R.drawable.ic_stat_rain)
                                .setStyle(
                                        new NotificationCompat.BigTextStyle()
                                                .bigText(notificationText)
                                                .setSummaryText("Mountain View"))
                                .extend(wearableExtender)
                                .build();
                        mNotificationManager.notify(NOTIF_WEATHER_ID, notification);
                    }
                });
    }

    private Notification createRetrofitErrorNotification(RetrofitError e) {
        String contentText;
        if (e.isNetworkError()) {
            contentText = getString(R.string.error_network);
        } else {
            contentText = getString(R.string.error_non_network);
        }
        return createErrorNotification(contentText);
    }

    private Notification createErrorNotification(String contentText) {
        return mBuilderProvider.get()
                .setTicker(contentText)
                .setContentTitle(getString(R.string.error))
                .setContentText(contentText)
                .addAction(android.R.drawable.ic_media_rew, "Retry", null)
                .build();

    }
}
