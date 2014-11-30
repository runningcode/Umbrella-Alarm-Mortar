package com.osacky.umbrella.ui.now;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
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
import lecho.lib.hellocharts.model.SimpleValueFormatter;
import lecho.lib.hellocharts.view.LineChartView;
import mortar.Mortar;
import retrofit.RetrofitError;
import rx.RetrofitObserver;

public class NowView extends FrameLayout {

    @Inject protected NowScreen.Presenter mPresenter;

    @InjectView(R.id.now_progress) protected View mProgress;
    @InjectView(R.id.now_content) protected View mContent;
    @InjectView(R.id.current_temp) protected TextView mCurrentTemp;
    @InjectView(R.id.text_current_weather) protected TextView mWeatherText;
    @InjectView(R.id.attribution) protected TextView mAttribution;
    @InjectView(R.id.graph) protected LineChartView mChartView;

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
                    Axis axisX = new Axis();
                    axisX.setName("min");
                    List<AxisValue> yAxisValueList = new ArrayList<>();
                    yAxisValueList.add(new AxisValue(0));
                    yAxisValueList.add(new AxisValue(.13f, "LOW".toCharArray()));
                    yAxisValueList.add(new AxisValue(.26f, "MED".toCharArray()));
                    yAxisValueList.add(new AxisValue(.34f, "HIGH".toCharArray()));
                    Axis axisY = new Axis(yAxisValueList);
                    axisY.setHasLines(true);
                    axisY.setFormatter(new SimpleValueFormatter(2));

                    lineChartData.setAxisXBottom(axisX);
                    lineChartData.setAxisYLeft(axisY);
                    mChartView.setLineChartData(lineChartData);
                    mChartView.setVisibility(VISIBLE);
                } else {
                    mChartView.setVisibility(GONE);
                }
                mContent.setVisibility(VISIBLE);
                mProgress.setVisibility(GONE);

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
