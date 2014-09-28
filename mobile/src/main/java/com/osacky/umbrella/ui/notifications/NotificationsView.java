package com.osacky.umbrella.ui.notifications;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.osacky.umbrella.R;
import com.osacky.umbrella.data.api.model.RainSummary;
import com.osacky.umbrella.util.Strings;

import org.joda.time.LocalTime;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mortar.Mortar;
import retrofit.RetrofitError;
import rx.RetrofitObserver;

public class NotificationsView extends LinearLayout {

    @Inject NotificationsScreen.Presenter mPresenter;

    @InjectView(R.id.time_picker) TimePicker mTimePicker;

    public NotificationsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            Mortar.inject(context, this);
        }
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) return;
        ButterKnife.inject(this);
        LocalTime defaultTime = mPresenter.getDefaultTime();
        mTimePicker.setCurrentHour(defaultTime.getHourOfDay());
        mTimePicker.setCurrentMinute(defaultTime.getMinuteOfHour());
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mPresenter.onTimeChanged(hourOfDay, minute);
            }
        });
        mPresenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        mPresenter.dropView(this);
        super.onDetachedFromWindow();
    }
}
