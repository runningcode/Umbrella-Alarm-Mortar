package com.osacky.umbrella.ui.hourly;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osacky.umbrella.R;
import com.osacky.umbrella.util.Strings;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mortar.Mortar;
import retrofit.RetrofitError;
import rx.RetrofitObserver;

public class TodayView extends LinearLayout {

    @Inject protected TodayScreen.Presenter mPresenter;

    @InjectView(R.id.current_temp) protected TextView mCurrentTemp;
    @InjectView(R.id.text_current_weather) protected TextView mWeatherText;
    @InjectView(R.id.chance_of_rain) protected TextView mChanceOfRain;
    @InjectView(R.id.attribution) protected TextView mAttribution;

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

        mPresenter.getSubscription(new RetrofitObserver<TodayWeatherSummary>() {
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
            }
        });
        mPresenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        mPresenter.dropView(this);
        super.onDetachedFromWindow();
    }
}
