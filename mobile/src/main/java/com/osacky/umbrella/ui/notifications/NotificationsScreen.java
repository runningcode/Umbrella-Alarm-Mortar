package com.osacky.umbrella.ui.notifications;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;

import com.osacky.umbrella.R;
import com.osacky.umbrella.actionbar.ActionBarConfig;
import com.osacky.umbrella.actionbar.ActionBarOwner;
import com.osacky.umbrella.alarm.DailyAlarmHelper;
import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.anim.Transition;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.StateBlueprint;
import com.osacky.umbrella.core.util.TransitionScreen;
import com.osacky.umbrella.data.prefs.IntPreference;
import com.osacky.umbrella.data.prefs.annotations.TimePref;
import com.osacky.umbrella.ui.base.BaseTabScreen;
import com.osacky.umbrella.util.ObjectUtils;

import org.joda.time.LocalTime;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import flow.HasParent;
import flow.Layout;

@Layout(R.layout.view_notifications)
@Transition({R.animator.slide_in_right, R.animator.slide_out_left, R.animator.slide_in_left, R.animator.slide_out_right})
public class NotificationsScreen extends TransitionScreen implements StateBlueprint, HasParent<BaseTabScreen> {

    private SparseArray<Parcelable> mViewState;

    @Override public String getMortarScopeName() {
        return ObjectUtils.getClass(this).getName();
    }

    @Override public Object getDaggerModule() {
        return new Module(mViewState);
    }

    @Override public void setViewState(SparseArray<Parcelable> viewState) {
        mViewState = viewState;
    }

    @Override public BaseTabScreen getParent() {
        return new BaseTabScreen();
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
        private final DailyAlarmHelper mDailyAlarmHelper;

        @Inject
        public Presenter(
                SparseArray<Parcelable> viewState,
                @TimePref IntPreference timePreference,
                DailyAlarmHelper dailyAlarmHelper,
                ActionBarOwner actionBarOwner
        ) {
            super(viewState);
            mActionBarOwner = actionBarOwner;
            mTimePreference = timePreference;
            mDailyAlarmHelper = dailyAlarmHelper;
            mActionBarConfig = new ActionBarConfig.Builder()
                    .title(R.string.menu_title_notifications)
                    .upButtonEnabled(true)
                    .build();
        }

        @Override public void onLoad(Bundle savedInstanceState) {
            super.onLoad(savedInstanceState);
            mActionBarOwner.setConfig(mActionBarConfig);
        }

        void onTimeChanged(int hourOfDay, int minute) {
            mTimePreference.set(new LocalTime(hourOfDay, minute).getMillisOfDay());
            mDailyAlarmHelper.setAlarm();
        }

        LocalTime getDefaultTime() {
            return LocalTime.fromMillisOfDay(mTimePreference.get());
        }
    }

}
