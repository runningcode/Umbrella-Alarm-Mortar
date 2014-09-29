package com.osacky.umbrella.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.service.HourlyCheckService;

import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Singleton;

import static android.app.AlarmManager.RTC_WAKEUP;
import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.KITKAT;
import static org.joda.time.DateTimeConstants.MILLIS_PER_MINUTE;

@Singleton
public class HourlyAlarmHelper {

    private static final int TEN_MINUTES = MILLIS_PER_MINUTE * 10;

    private final AlarmManager mAlarmManager;
    private final PendingIntent mPendingIntent;

    @Inject
    HourlyAlarmHelper(UmbrellaApplication app, AlarmManager alarmManager) {
        mAlarmManager = alarmManager;
        Intent checkIntent = new Intent(app, HourlyCheckService.class);
        mPendingIntent = PendingIntent.getService(app, 0, checkIntent, 0);
    }

    public void cancelAlarm() {
        mAlarmManager.cancel(mPendingIntent);
    }

    public void setAlarm(DateTime dateTime) {
        cancelAlarm();
        if (dateTime.isBeforeNow()) {
            dateTime = dateTime.plusHours(1);
        }
        if (SDK_INT > KITKAT) {
            mAlarmManager.setWindow(RTC_WAKEUP, dateTime.minusMinutes(10).getMillis(), TEN_MINUTES, mPendingIntent);
        } else {
            mAlarmManager.set(RTC_WAKEUP, dateTime.getMillis(), mPendingIntent);
        }
    }
}
