package com.osacky.umbrella.service;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.osacky.umbrella.R;
import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.data.api.model.CondUtils;
import com.osacky.umbrella.data.api.model.RainPeriod;
import com.osacky.umbrella.data.api.model.RainPeriodResult;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.functions.Func1;

@Singleton
public class PeriodsToString implements Func1<List<RainPeriod>, CharSequence> {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormat.shortTime();
    private final Context mContext;

    @Inject
    public PeriodsToString(UmbrellaApplication context) {
        mContext = context;
    }

    @Override public CharSequence call(List<RainPeriod> rainPeriods) {
        if (rainPeriods.isEmpty()) {
            return null;
        } else if (rainPeriods.size() == 1) {
            RainPeriod period = rainPeriods.get(0);
            String start = period.getStart().toString(TIME_FORMAT);
            String end = period.getEnd().toString(TIME_FORMAT);
            return String.format(mContext.getString(R.string.single_rain),
                    mContext.getString(CondUtils.getStringResIdForCondCode(period.getCondition())),
                    start, end);
        } else {
            StringBuilder stringBuilder = new StringBuilder(mContext.getString(R.string.multiple_rain));

            for (RainPeriod period : rainPeriods) {
                String start = period.getStart().toString(TIME_FORMAT);
                String end = period.getEnd().toString(TIME_FORMAT);
                stringBuilder.append(
                        String.format(
                                mContext.getString(R.string.multiple_rain_item),
                                mContext.getString(CondUtils.getStringResIdForCondCode(period.getCondition())),
                                start, end));
            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("\n"));
            return stringBuilder.toString();
        }
    }
}
