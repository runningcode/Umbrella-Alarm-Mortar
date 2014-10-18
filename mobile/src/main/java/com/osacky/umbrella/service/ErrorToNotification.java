package com.osacky.umbrella.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.osacky.umbrella.R;
import com.osacky.umbrella.UmbrellaApplication;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import retrofit.RetrofitError;
import rx.functions.Func1;

@Singleton
public class ErrorToNotification implements Func1<RetrofitError, Notification> {

    private final Provider<NotificationCompat.Builder> mBuilderProvider;
    private final Context mContext;

    @Inject
    public ErrorToNotification(Provider<NotificationCompat.Builder> builderProvider,
                               UmbrellaApplication context) {
        mBuilderProvider = builderProvider;
        mContext = context;
    }

    @Override public Notification call(RetrofitError retrofitError) {
        String contentText;
        if (retrofitError.getKind() == RetrofitError.Kind.NETWORK) {
            contentText = mContext.getString(R.string.error_network);
        } else {
            contentText = mContext.getString(R.string.error_non_network);
        }
        Intent intent = new Intent(mContext, DailyCheckService.class);
        PendingIntent pendingIntent = PendingIntent.getService(mContext, 0, intent, 0);
        return mBuilderProvider.get()
                .setTicker(contentText)
                .setContentTitle(mContext.getString(R.string.error))
                .setContentText(contentText)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .addAction(android.R.drawable.ic_menu_rotate, mContext.getString(R.string
                        .ic_notif_action_retry), pendingIntent)
                .build();
    }
}
