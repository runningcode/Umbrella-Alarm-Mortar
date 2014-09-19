package com.osacky.umbrella.service;

import android.content.Context;

import com.osacky.umbrella.R;
import com.osacky.umbrella.data.api.model.CondUtils;
import com.osacky.umbrella.data.api.model.RainPeriod;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

import rx.functions.Func1;

public class ProcessPeriods implements Func1<List<RainPeriod>, CharSequence> {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormat.shortTime();
    private final Context mContext;

    public ProcessPeriods(Context context) {
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
