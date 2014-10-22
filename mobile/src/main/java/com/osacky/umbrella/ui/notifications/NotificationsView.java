package com.osacky.umbrella.ui.notifications;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import com.osacky.umbrella.R;

import org.joda.time.LocalTime;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mortar.Mortar;

public class NotificationsView extends LinearLayout {

    @Inject NotificationsScreen.Presenter mPresenter;

    @InjectView(R.id.time_picker) TimePicker mTimePicker;
    @InjectView(R.id.toolbar) Toolbar mToolbar;

    public NotificationsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            Mortar.inject(context, this);
        }
    }

    void setTitle(@StringRes int title) {
        mToolbar.setTitle(title);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) return;
        ButterKnife.inject(this);
        mToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        mToolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                mPresenter.onUpClicked();
            }
        });
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
