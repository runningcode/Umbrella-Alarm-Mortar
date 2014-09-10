package com.osacky.umbrella.ui.time;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import org.joda.time.LocalTime;

import mortar.Popup;
import mortar.PopupPresenter;

public class TimePickerPopup implements Popup<TimeInfo, LocalTime> {

    private final Context mContext;

    private TimePickerDialog mDialog;

    public TimePickerPopup(Context context) {
        mContext = context;
    }

    @Override
    public void show(TimeInfo info, boolean withFlourish,
                     final PopupPresenter<TimeInfo, LocalTime> presenter) {
        if (mDialog != null) throw new IllegalStateException("Already showing can't show " + info);

        mDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {

            @Override public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mDialog = null;
                presenter.onDismissed(new LocalTime(hourOfDay, minute));
            }
        }, info.mLocalTime.getHourOfDay(), info.mLocalTime.getMinuteOfHour(), false);

        mDialog.show();
    }

    @Override public boolean isShowing() {
        return mDialog != null;
    }

    @Override public void dismiss(boolean withFlourish) {
        mDialog.dismiss();
        mDialog = null;
    }

    @Override public Context getContext() {
        return mContext;
    }
}
