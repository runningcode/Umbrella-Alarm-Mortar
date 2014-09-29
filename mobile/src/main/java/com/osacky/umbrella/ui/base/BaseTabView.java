package com.osacky.umbrella.ui.base;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.osacky.umbrella.R;
import com.osacky.umbrella.core.util.StateBlueprint;
import com.osacky.umbrella.mortar.ScreenPagerAdapter;
import com.osacky.umbrella.ui.forecast.ForecastScreen;
import com.osacky.umbrella.ui.hourly.TodayScreen;
import com.osacky.umbrella.ui.now.NowScreen;
import com.osacky.umbrella.widget.SlidingTabLayout;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mortar.Mortar;

public class BaseTabView extends LinearLayout {

    @Inject BaseTabScreen.Presenter mPresenter;

    @InjectView(R.id.sliding_tabs) SlidingTabLayout mSlidingTabLayout;
    @InjectView(R.id.viewpager) ViewPager mViewPager;

    private final WeatherPagerAdapter mAdapter = new WeatherPagerAdapter();

    public BaseTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Mortar.inject(context, this);
        mAdapter.addScreen(new NowScreen(), new TodayScreen(), new ForecastScreen());
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
        mSlidingTabLayout.setDistributeEvenly(
                getContext().getResources().getBoolean(R.bool.distribute_evenly));
        mViewPager.setAdapter(mAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override public int getIndicatorColor(int position) {
                return getContext().getResources().getColor(R.color.theme_accent);
            }
        });
        mPresenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.dropView(this);
    }

    class WeatherPagerAdapter extends ScreenPagerAdapter<StateBlueprint> {
        @Override public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getContext().getString(R.string.tab_now);
                case 1:
                    return getContext().getString(R.string.tab_today);
                case 2:
                    return getContext().getString(R.string.tab_forecast);
                default:
                    throw new IllegalArgumentException("This tab does not have a title set");
            }
        }
    }

}
