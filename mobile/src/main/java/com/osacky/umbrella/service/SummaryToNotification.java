package com.osacky.umbrella.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.osacky.umbrella.MainActivity;
import com.osacky.umbrella.R;
import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.data.api.model.RainSummary;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import rx.functions.Func1;

@Singleton
public class SummaryToNotification implements Func1<RainSummary, Notification> {

    private final Provider<NotificationCompat.Builder> mBuilderProvider;
    private final Context mContext;

    @Inject
    public SummaryToNotification(
            Provider<NotificationCompat.Builder> builderProvider,
            UmbrellaApplication app
    ) {
        mBuilderProvider = builderProvider;
        mContext = app;
    }

    @Override public Notification call(RainSummary rainPeriodResult) {
        if (rainPeriodResult == null || rainPeriodResult.getChanceOfRain() == 0) {
            return null;
        }
        Intent intent = new Intent(mContext, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent, 0);
        return mBuilderProvider.get()
                .setTicker(rainPeriodResult.getSummary())
                .setContentTitle(mContext.getString(R.string.notif_title))
                .setContentText(rainPeriodResult.getSummary())
                .setContentIntent(pendingIntent)
                .setStyle(
                        new NotificationCompat.BigTextStyle()
                                .bigText(rainPeriodResult.getSummary())
                                .setSummaryText(rainPeriodResult.getCityName()))
                .build();
    }
}
