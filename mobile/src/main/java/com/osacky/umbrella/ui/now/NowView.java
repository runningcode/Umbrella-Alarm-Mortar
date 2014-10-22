package com.osacky.umbrella.ui.now;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ScrollView;
import android.widget.TextView;

import com.osacky.umbrella.R;
import com.osacky.umbrella.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.view.LineChartView;
import mortar.Mortar;
import retrofit.RetrofitError;
import rx.RetrofitObserver;

public class NowView extends ScrollView {

    @Inject NowScreen.Presenter mPresenter;

    @InjectView(R.id.current_temp) TextView mCurrentTemp;
    @InjectView(R.id.text_current_weather) TextView mWeatherText;
    @InjectView(R.id.attribution) TextView mAttribution;
    @InjectView(R.id.graph) LineChartView mChartView;

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
        final Resources resources = getContext().getResources();
        setUpGraph(resources);
        Strings.addLink(mAttribution, "Forecast", "http://forecast.io/");

        mPresenter.getSubscription(new RetrofitObserver<NowWeatherSummary>() {
            @Override public void onRetrofitError(RetrofitError e) {
            }

            @Override public void onNext(NowWeatherSummary rainSummary) {
                mCurrentTemp.setText(String.format(resources.getString(R.string.temp_current),
                        (int) rainSummary.getCurrentTemp()));
                mWeatherText.setText(rainSummary.getSummary());
                if (rainSummary.isWillRain()) {
                    Line line = new Line(rainSummary.getData());
                    line.setFilled(true);
                    line.setCubic(true);
                    line.setHasPoints(false);
                    line.setColor(resources.getColor(R.color.theme_accent));
                    LineChartData lineChartData = new LineChartData(Arrays.asList(line));
                    lineChartData.setBaseValue(0);
                    Axis axisX = new Axis();
                    Axis axisY = new Axis();
                    lineChartData.setAxisXBottom(axisX);
                    lineChartData.setAxisYLeft(axisY);
                    mChartView.setLineChartData(lineChartData);
                    mChartView.setVisibility(VISIBLE);
                } else {
                    mChartView.setVisibility(GONE);
                }

            }
        });
        mPresenter.takeView(this);
    }

    // GraphView's api is terrible
    private void setUpGraph(Resources resources) {
//        GraphViewStyle graphStyle = mLineGraph.getGraphViewStyle();
//        graphStyle.setGridStyle(GraphViewStyle.GridStyle.HORIZONTAL);
//        graphStyle.setHorizontalLabelsColor(resources.getColor(R.color.text_primary));
//        graphStyle.setVerticalLabelsColor(resources.getColor(R.color.text_primary));
//        graphStyle.setVerticalLabelsAlign(Paint.Align.LEFT);
//        graphStyle.setTextSize(resources.getDimension(R.dimen.text_size_xsmall));
//        mLineGraph.setVerticalLabels(resources.getStringArray(R.array.graph_labels_vert));
//        mLineGraph.setHorizontalLabels(resources.getStringArray(R.array.graph_labels_horiz));
//        mLineGraph.setManualYMaxBound(0.4);
//        mLineGraph.setManualYMinBound(0);
//        mLineGraph.setDisableTouch(true);
//        mLineGraph.setBackgroundColor(resources.getColor(R.color.theme_accent_light));
//        mLineGraph.setDrawBackground(true);
    }

    @Override protected void onDetachedFromWindow() {
        mPresenter.dropView(this);
        super.onDetachedFromWindow();
    }
}
