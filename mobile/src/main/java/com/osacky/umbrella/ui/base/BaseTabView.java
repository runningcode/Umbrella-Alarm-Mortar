package com.osacky.umbrella.ui.base;

import android.content.Context;
import android.support.annotation.MenuRes;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.osacky.umbrella.R;
import com.osacky.umbrella.core.util.Path;
import com.osacky.umbrella.ui.forecast.ForecastScreen;
import com.osacky.umbrella.ui.hourly.TodayScreen;
import com.osacky.umbrella.ui.now.NowScreen;
import com.osacky.umbrella.widget.ScreenPagerAdapter;
import com.osacky.umbrella.widget.SlidingTabLayout;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mortar.Mortar;

public class BaseTabView extends LinearLayout {

    @Inject protected BaseTabScreen.Presenter mPresenter;

    @InjectView(R.id.toolbar) protected Toolbar mToolbar;
    @InjectView(R.id.sliding_tabs) protected SlidingTabLayout mSlidingTabLayout;
    @InjectView(R.id.viewpager) protected ViewPager mViewPager;

    private final WeatherPagerAdapter mAdapter = new WeatherPagerAdapter();

    public BaseTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mAdapter.addScreen(new NowScreen(), new TodayScreen(), new ForecastScreen());
        Mortar.inject(context, this);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
        mSlidingTabLayout.setDistributeEvenly(
                getContext().getResources().getBoolean(R.bool.distribute_evenly));
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mSlidingTabLayout.setViewPager(mViewPager);
        mPresenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.dropView(this);
    }

    void setTitle(CharSequence chanceOfRain) {
        mToolbar.setTitle(chanceOfRain);
    }

    void setMenu(@MenuRes int menuId, Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        mToolbar.inflateMenu(menuId);
        mToolbar.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    class WeatherPagerAdapter extends ScreenPagerAdapter<Path> {
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
