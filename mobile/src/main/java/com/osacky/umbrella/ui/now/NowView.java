package com.osacky.umbrella.ui.now;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.echo.holographlibrary.LineGraph;
import com.osacky.umbrella.R;
import com.osacky.umbrella.util.Strings;

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
    @InjectView(R.id.attribution) TextView mAttribution;
    @InjectView(R.id.graph) LineGraph mLineGraph;

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
                mCurrentTemp.setText(String.format(getContext().getString(R.string.temp_current), (int) rainSummary.getCurrentTemp()));
                mWeatherText.setText(rainSummary.getSummary());
                mLineGraph.addLine(rainSummary.getLine());
                mLineGraph.setLineToFill(0);
                mLineGraph.setRangeX(0, 60);
                mLineGraph.setRangeY(0, .5f);
            }
        });
        mPresenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        mPresenter.dropView(this);
        super.onDetachedFromWindow();
    }
}
