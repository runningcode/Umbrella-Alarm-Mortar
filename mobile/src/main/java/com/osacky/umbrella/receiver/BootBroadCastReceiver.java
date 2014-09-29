package com.osacky.umbrella.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.alarm.DailyAlarmHelper;

import javax.inject.Inject;

import hugo.weaving.DebugLog;


public class BootBroadCastReceiver extends BroadcastReceiver {

    @Inject
    DailyAlarmHelper mDailyAlarmHelper;

    @Override @DebugLog public void onReceive(Context context, Intent intent) {
        UmbrellaApplication.get(context).getObjectGraph().plus(new ReceiverModule()).inject(this);
        mDailyAlarmHelper.setAlarm();
    }
}
