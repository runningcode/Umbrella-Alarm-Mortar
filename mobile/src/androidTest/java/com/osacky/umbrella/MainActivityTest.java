package com.osacky.umbrella;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class MainActivityTest {

    private MainActivity mActivity;
    private ActivityController<MainActivity> mController;

    @Before
    public void setUp() throws Exception {
        mController = Robolectric.buildActivity(MainActivity.class).create();
        mActivity = mController.get();
    }

    @Test
    public void testActivityNotNull() throws Exception {
        Assertions.assertThat(mActivity).isNotNull();
    }

    @Test
    public void testStartAndResume() {
        mController.start().resume();
        Assertions.assertThat(mActivity.isRunning()).isTrue();
        mController.pause();
        Assertions.assertThat(mActivity.isRunning()).isFalse();
    }

    @Test
    public void testActivityPresenter() {
        Assertions.assertThat(mActivity.getActivity()).isEqualTo(mActivity);
    }

}
