package com.osacky.umbrella.service;

import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.osacky.umbrella.R;
import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.alarm.HourlyAlarmHelper;
import com.osacky.umbrella.data.api.WeatherUtils;
import com.osacky.umbrella.data.api.model.Condition;
import com.osacky.umbrella.data.api.model.WeatherResult;

import org.joda.time.DateTime;
import org.joda.time.Minutes;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import rx.functions.Func1;

@Singleton
public class WeatherToAlarms implements Func1<WeatherResult, WeatherResult> {

    private final HourlyAlarmHelper mHourlyAlarmHelper;
    private final Provider<NotificationCompat.Builder> mBuilderProvider;
    private final Context mContext;

    @Inject
    public WeatherToAlarms(HourlyAlarmHelper hourlyAlarmHelper, Provider<NotificationCompat
            .Builder> builderProvider, UmbrellaApplication application) {
        mHourlyAlarmHelper = hourlyAlarmHelper;
        mBuilderProvider = builderProvider;
        mContext = application;
    }

    @Override public WeatherResult call(WeatherResult weatherResult) {
        for (Condition condition : weatherResult.getMinutely().getData()) {
            if (WeatherUtils.isConditionRain(condition)) {
                showNowNotif(condition);
                return weatherResult;
            }
        }
        for (Condition condition : weatherResult.getHourly().getData()) {
            if (WeatherUtils.isConditionRain(condition)) {
                scheduleAlarmForLater(condition);
                return weatherResult;
            }
        }
        return weatherResult;
    }

    private void scheduleAlarmForLater(Condition condition) {
        mHourlyAlarmHelper.setAlarm(condition.getDateTime());
    }

    private void showNowNotif(Condition condition) {
        int minutes = Minutes.minutesBetween(DateTime.now(), condition.getDateTime()).getMinutes();
        String string = mContext.getResources().getQuantityString(
                R.plurals.notif_rain_imminent, minutes, minutes);
        mBuilderProvider.get()
                .setTicker(string)
                .setContentTitle(mContext.getString(R.string.notif_title))
                .setContentText(string)
                .setStyle(
                        new NotificationCompat.BigTextStyle()
                                .bigText(string))
                // TODO maybe show city
                .build();

    }
}
