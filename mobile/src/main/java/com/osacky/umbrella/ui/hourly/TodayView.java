package com.osacky.umbrella.ui.hourly;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.osacky.umbrella.R;
import com.osacky.umbrella.util.Strings;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mortar.Mortar;
import retrofit.RetrofitError;
import rx.RetrofitObserver;
import rx.Subscription;

public class TodayView extends FrameLayout {

    @Inject protected TodayScreen.Presenter mPresenter;

    @InjectView(R.id.today_progress) protected View mProgress;
    @InjectView(R.id.today_content) protected View mContent;
    @InjectView(R.id.current_temp) protected TextView mCurrentTemp;
    @InjectView(R.id.text_current_weather) protected TextView mWeatherText;
    @InjectView(R.id.chance_of_rain) protected TextView mChanceOfRain;
    @InjectView(R.id.attribution) protected TextView mAttribution;

    private Subscription subscription;

    public TodayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            Mortar.inject(context, this);
        }
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) return;
        ButterKnife.inject(this);
        Strings.addLink(mAttribution, "Forecast", "http://forecast.io/");

    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        subscription = mPresenter.getSubscription(new RetrofitObserver<TodayWeatherSummary>() {
            @Override public void onRetrofitError(RetrofitError e) {
            }

            @Override public void onNext(TodayWeatherSummary rainSummary) {
                mCurrentTemp.setText(
                        String.format(getContext().getString(R.string.temp_high_low),
                                (int) rainSummary.getLowTemp(),
                                (int) rainSummary.getHighTemp()
                        ));
                mWeatherText.setText(rainSummary.getSummary());
                mChanceOfRain.setText(String.format(getContext().getString(R.string
                        .chance_of_rain_today), rainSummary.getChanceOfRain()));
                mProgress.setVisibility(GONE);
                mContent.setVisibility(VISIBLE);
            }
        });
        mPresenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        subscription.unsubscribe();
        mPresenter.dropView(this);
    }
}
