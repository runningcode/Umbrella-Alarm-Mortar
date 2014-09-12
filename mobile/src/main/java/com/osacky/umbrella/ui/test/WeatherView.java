package com.osacky.umbrella.ui.test;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.osacky.umbrella.R;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mortar.Mortar;
import retrofit.RetrofitError;
import rx.Observer;
import rx.RetrofitObserver;
import rx.Subscription;
import timber.log.Timber;

public class WeatherView extends LinearLayout {

    @Inject WeatherScreen.Presenter mPresenter;

    @InjectView(R.id.text_current_weather) TextView mWeatherText;
    @InjectView(R.id.time_picker) TimePicker mTimePicker;

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            Mortar.inject(context, this);
        }
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) return;
        ButterKnife.inject(this);
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mPresenter.onTimeChanged(hourOfDay, minute);
            }
        });
        mPresenter.getSubscription(new RetrofitObserver<WeatherForecastResult>() {
            @Override public void onRetrofitError(RetrofitError e) {

            }

            @Override public void onNext(WeatherForecastResult weatherForecastResult) {
                mWeatherText.setText(weatherForecastResult.getList().get(0).getWeather().getDescription());
            }
        });
        mPresenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        mPresenter.dropView(this);
        super.onDetachedFromWindow();
    }
}
