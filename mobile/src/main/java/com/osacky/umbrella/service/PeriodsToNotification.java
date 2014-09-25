package com.osacky.umbrella.service;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.osacky.umbrella.R;
import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.data.api.model.RainPeriodResult;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import rx.functions.Func1;

@Singleton
public class PeriodsToNotification implements Func1<RainPeriodResult, Notification> {

    private final Provider<NotificationCompat.Builder> mBuilderProvider;
    private final PeriodsToString mPeriodsToString;
    private final Context mContext;

    @Inject
    public PeriodsToNotification(
            Provider<NotificationCompat.Builder> builderProvider,
            PeriodsToString periodsToString,
            UmbrellaApplication app
    ) {
        mBuilderProvider = builderProvider;
        mPeriodsToString = periodsToString;
        mContext = app;
    }

    @Override public Notification call(RainPeriodResult rainPeriodResult) {
        CharSequence rainText = mPeriodsToString.call(rainPeriodResult.getRainPeriods());
        if (rainText == null) {
            // it is not going to rain anytime soon;
            return null;
        }

        return mBuilderProvider.get()
                .setTicker(rainText)
                .setContentTitle(mContext.getString(R.string.notif_title))
                .setContentText(rainText)
                .setSmallIcon(R.drawable.ic_stat_rain)
                .setStyle(
                        new NotificationCompat.BigTextStyle()
                                .bigText(rainText)
                                .setSummaryText(rainPeriodResult.getCityName()))
                .build();
    }
}
