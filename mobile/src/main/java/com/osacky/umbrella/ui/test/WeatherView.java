package com.osacky.umbrella.ui.test;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osacky.umbrella.R;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;
import com.osacky.umbrella.ui.time.TimeInfo;
import com.osacky.umbrella.ui.time.TimePickerPopup;

import org.joda.time.Duration;
import org.joda.time.LocalTime;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mortar.Mortar;
import mortar.Popup;
import rx.Observer;
import rx.Subscription;
import timber.log.Timber;

public class WeatherView extends LinearLayout {

    @Inject WeatherScreen.Presenter mPresenter;

    @InjectView(R.id.text_current_weather) TextView mWeatherText;

    private Subscription mSubscription;
    private Popup<TimeInfo, LocalTime> mPopup;

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPopup = new TimePickerPopup(context);
        if (!isInEditMode()) {
            Mortar.inject(context, this);
        }
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) return;
        ButterKnife.inject(this);
        mPresenter.takeView(this);
        mSubscription = mPresenter.getSubscription(new Observer<WeatherForecastResult>() {
            @Override public void onCompleted() {
            }

            @Override public void onError(Throwable e) {
                Timber.e(e, "error fetching weather");
            }

            @Override public void onNext(WeatherForecastResult weatherForecastResult) {
                mWeatherText.setText(weatherForecastResult.getList().get(0).getWeather().getDescription());
                Timber.i("Result obtained");
            }
        });
    }

    @Override protected void onDetachedFromWindow() {
        mSubscription.unsubscribe();
        mPresenter.dropView(this);
        super.onDetachedFromWindow();
    }

    @OnClick(R.id.set_time_button)
    void onTimeClicked() {
        mPresenter.onTimeClicked();
    }

    public Popup<TimeInfo, LocalTime> getPopup() {
        return mPopup;
    }
}
