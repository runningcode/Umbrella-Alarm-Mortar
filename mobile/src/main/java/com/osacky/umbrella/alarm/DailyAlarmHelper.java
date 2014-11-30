package com.osacky.umbrella.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.annotations.TimePref;
import com.osacky.umbrella.service.DailyCheckService;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import javax.inject.Inject;
import javax.inject.Singleton;

import static android.app.AlarmManager.RTC_WAKEUP;
import static org.joda.time.DateTimeConstants.MILLIS_PER_DAY;

@Singleton
public class DailyAlarmHelper {

    private final AlarmManager mAlarmManager;
    private final IntPreference mTimePreference;
    private final PendingIntent mPendingIntent;

    @Inject
    DailyAlarmHelper(
            UmbrellaApplication app,
            AlarmManager alarmManager,
            @TimePref IntPreference timePreference
    ) {
        mAlarmManager = alarmManager;
        mTimePreference = timePreference;
        Intent checkIntent = new Intent(app, DailyCheckService.class);
        mPendingIntent = PendingIntent.getService(app, 0, checkIntent, 0);
    }

    public void cancelAlarm() {
        mAlarmManager.cancel(mPendingIntent);
    }

    public void setAlarm() {
        cancelAlarm();
        DateTime triggerTime = LocalTime.fromMillisOfDay(mTimePreference.get()).toDateTimeToday();

        // TODO check if we just missed the alarm
        if (triggerTime.isBeforeNow()) {
            triggerTime = triggerTime.plusDays(1);
        }
        mAlarmManager.setRepeating(RTC_WAKEUP, triggerTime.getMillis(), MILLIS_PER_DAY, mPendingIntent);
    }
}
