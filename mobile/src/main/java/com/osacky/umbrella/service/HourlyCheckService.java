package com.osacky.umbrella.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.osacky.umbrella.R;
import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.data.api.ForecastWeatherManager;

import javax.inject.Inject;
import javax.inject.Provider;

import retrofit.RetrofitError;
import rx.RetrofitObserver;

public class HourlyCheckService extends IntentService {

    @Inject protected NotificationManagerCompat mNotificationManager;
    @Inject protected Provider<Location> mLocationProvider;
    @Inject protected ForecastWeatherManager mWeatherManager;
    @Inject protected Provider<NotificationCompat.Builder> mBuilderProvider;
    @Inject protected WeatherToHourlySummary mWeatherToHourlySummary;
    @Inject protected SummaryToNotification mSummaryToNotification;
    @Inject protected ErrorToNotification mErrorToNotification;

    private static final int NOTIF_WEATHER_ID = 0;
    private static final int NOTIF_LOCATION_ERROR_ID = 1;
    private static final int NOTIF_RETROFIT_ERROR_ID = 2;

    public HourlyCheckService() {
        super(HourlyCheckService.class.getSimpleName());
    }

    @Override public void onCreate() {
        super.onCreate();
        UmbrellaApplication.get(this).getObjectGraph().plus(new ServiceModule(this)).inject(this);
    }

    @Override protected void onHandleIntent(Intent intent) {
        mNotificationManager.cancelAll();
        Location lastLocation = mLocationProvider.get();
        if (lastLocation == null) {
            String contentText = getString(R.string.error_null_location);
            Intent notifIntent = new Intent(this, DailyCheckService.class);
            PendingIntent pendingIntent = PendingIntent.getService(this, 0, notifIntent, 0);
            Notification notification = mBuilderProvider.get()
                    .setTicker(contentText)
                    .setContentTitle(getString(R.string.error))
                    .setContentText(contentText)
                    .setContentIntent(pendingIntent)
                    .addAction(android.R.drawable.ic_menu_rotate, "Retry", pendingIntent)
                    .build();
            mNotificationManager.notify(NOTIF_LOCATION_ERROR_ID,notification);
            return;
        }

        mWeatherManager.get(lastLocation.getLatitude(), lastLocation.getLongitude())
                .map(mWeatherToHourlySummary)
                .map(mSummaryToNotification)
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
