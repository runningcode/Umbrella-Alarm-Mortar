package com.osacky.umbrella.ui.now;

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

public class NowView extends LinearLayout {

    @Inject NowScreen.Presenter mPresenter;

    @InjectView(R.id.current_temp) TextView mCurrentTemp;
    @InjectView(R.id.text_current_weather) TextView mWeatherText;
    @InjectView(R.id.chance_of_rain) TextView mChanceOfRain;
    @InjectView(R.id.weather_image) ImageView mWeatherImage;
    @InjectView(R.id.attribution) TextView mAttribution;

    public NowView(Context context, AttributeSet attrs) {
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

        mPresenter.getSubscription(new RetrofitObserver<NowWeatherSummary>() {
            @Override public void onRetrofitError(RetrofitError e) {
            }

            @Override public void onNext(NowWeatherSummary rainSummary) {
                mCurrentTemp.setText(String.format(getContext().getString(R.string.current_temperature), (int) rainSummary.getCurrentTemp()));
                mWeatherText.setText(rainSummary.getSummary());
                mChanceOfRain.setText(String.format(getContext().getString(R.string
                        .chance_of_rain), 0));
            }
        });
        mPresenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        mPresenter.dropView(this);
        super.onDetachedFromWindow();
    }
}
