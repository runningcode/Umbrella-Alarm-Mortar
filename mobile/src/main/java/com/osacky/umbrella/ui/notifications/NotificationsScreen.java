package com.osacky.umbrella.ui.notifications;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.R;
import com.osacky.umbrella.alarm.DailyAlarmHelper;
import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.anim.Transition;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.TransitionScreen;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.annotations.TimePref;
import com.osacky.umbrella.ui.base.BaseTabScreen;

import org.joda.time.LocalTime;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Flow;
import flow.HasParent;
import flow.Layout;
import mortar.ViewPresenter;

@Layout(R.layout.view_notifications)
@Transition({R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right})
public class NotificationsScreen extends TransitionScreen implements HasParent<BaseTabScreen> {

    @Override public Object getDaggerModule() {
        return new Module();
    }

    @Override public BaseTabScreen getParent() {
        return new BaseTabScreen();
    }

    @dagger.Module(
            injects = NotificationsView.class,
            addsTo = CorePresenter.Module.class
    )
    static class Module {
    }

    @Singleton
    public static class Presenter extends ViewPresenter<NotificationsView> {

        private final Flow mFlow;
        private final IntPreference mTimePreference;
        private final DailyAlarmHelper mDailyAlarmHelper;

        @Inject
        public Presenter(
                Flow flow,
                @TimePref IntPreference timePreference,
                DailyAlarmHelper dailyAlarmHelper
        ) {
            mFlow = flow;
            mTimePreference = timePreference;
            mDailyAlarmHelper = dailyAlarmHelper;
        }

        @Override public void onLoad(Bundle savedInstanceState) {
            super.onLoad(savedInstanceState);
            NotificationsView view = getView();
            if (view == null) return;
            view.setTitle(R.string.notif_title);
        }

        void onTimeChanged(int hourOfDay, int minute) {
            mTimePreference.set(new LocalTime(hourOfDay, minute).getMillisOfDay());
            mDailyAlarmHelper.setAlarm();
        }

        LocalTime getDefaultTime() {
            return LocalTime.fromMillisOfDay(mTimePreference.get());
        }

        void onUpClicked() {
            // this should be mFlow.goUp() but that causes a crash for some reason
            mFlow.goBack();
        }
    }

}
