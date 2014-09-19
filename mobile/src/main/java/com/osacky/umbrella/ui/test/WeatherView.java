package com.osacky.umbrella.ui.test;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.osacky.umbrella.R;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;
import com.osacky.umbrella.service.UmbrellaService;

import org.joda.time.LocalTime;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mortar.Mortar;
import retrofit.RetrofitError;
import rx.RetrofitObserver;

public class WeatherView extends LinearLayout {

    @Inject
    WeatherScreen.Presenter mPresenter;

    @InjectView(R.id.text_current_weather)
    TextView mWeatherText;
    @InjectView(R.id.time_picker)
    TimePicker mTimePicker;
    @InjectView(R.id.weather_image)
    ImageView mWeatherImage;

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
        LocalTime defaultTime = mPresenter.getDefaultTime();
        mTimePicker.setCurrentHour(defaultTime.getHourOfDay());
        mTimePicker.setCurrentMinute(defaultTime.getMinuteOfHour());
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mPresenter.onTimeChanged(hourOfDay, minute);
            }
        });
        mPresenter.getSubscription(new RetrofitObserver<WeatherForecastResult>() {
            @Override public void onRetrofitError(RetrofitError e) {

            }

            @Override public void onNext(WeatherForecastResult weatherForecastResult) {
                mWeatherText.setText(
                        weatherForecastResult.getList().get(0).getWeather().getDescription());
            }
        });
        getContext().startService(new Intent(getContext(), UmbrellaService.class));
        mPresenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        mPresenter.dropView(this);
        super.onDetachedFromWindow();
    }
}
