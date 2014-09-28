package com.osacky.umbrella.ui.notifications;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.R;
import com.osacky.umbrella.actionbar.ActionBarConfig;
import com.osacky.umbrella.actionbar.ActionBarOwner;
import com.osacky.umbrella.alarm.AlarmHelper;
import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.anim.Transition;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.StateBlueprint;
import com.osacky.umbrella.core.util.TransitionScreen;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.annotations.TimePref;

import org.joda.time.LocalTime;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Layout;

@Layout(R.layout.view_notifications)
@Transition({R.animator.slide_in_right, R.animator.slide_out_left, R.animator.slide_in_left, R.animator.slide_out_right})
public class NotificationsScreen extends TransitionScreen implements StateBlueprint {

    private SparseArray<Parcelable> mViewState;

    @Override public String getMortarScopeName() {
        return NotificationsScreen.class.getName();
    }

    @Override public Object getDaggerModule() {
        return new Module(mViewState);
    }

    @Override public void setViewState(SparseArray<Parcelable> viewState) {
        mViewState = viewState;
    }

    @dagger.Module(
            injects = NotificationsView.class,
            addsTo = CorePresenter.Module.class
    )
    static class Module {
        private final SparseArray<Parcelable> viewState;

        public Module(SparseArray<Parcelable> viewState) {
            this.viewState = viewState;
        }

        @Provides SparseArray<Parcelable> providesViewState() {
            return viewState;
        }
    }

    @Singleton
    public static class Presenter extends BetterViewPresenter<NotificationsView> {

        private final ActionBarOwner mActionBarOwner;
        private final ActionBarConfig mActionBarConfig;
        private final IntPreference mTimePreference;
        private final AlarmHelper mAlarmHelper;

        @Inject
        public Presenter(
                SparseArray<Parcelable> viewState,
                @TimePref IntPreference timePreference,
                AlarmHelper alarmHelper,
                ActionBarOwner actionBarOwner
        ) {
            super(viewState);
            mActionBarOwner = actionBarOwner;
            mTimePreference = timePreference;
            mAlarmHelper = alarmHelper;
            mActionBarConfig = new ActionBarConfig.Builder()
                    .title(R.string.menu_title_notifications)
                    .build();

        }

        @Override public void onLoad(Bundle savedInstanceState) {
            super.onLoad(savedInstanceState);
            mActionBarOwner.setConfig(mActionBarConfig);
        }

        void onTimeChanged(int hourOfDay, int minute) {
            mTimePreference.set(new LocalTime(hourOfDay, minute).getMillisOfDay());
            mAlarmHelper.setAlarm();
        }

        LocalTime getDefaultTime() {
            return LocalTime.fromMillisOfDay(mTimePreference.get());
        }
    }

}
