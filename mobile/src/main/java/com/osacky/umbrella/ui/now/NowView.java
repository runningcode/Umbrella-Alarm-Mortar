package com.osacky.umbrella.ui.now;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewStyle;
import com.jjoe64.graphview.LineGraphView;
import com.osacky.umbrella.R;
import com.osacky.umbrella.util.Strings;
import com.osacky.umbrella.widget.LineGraphHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mortar.Mortar;
import retrofit.RetrofitError;
import rx.RetrofitObserver;

import static com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;

public class NowView extends ScrollView {

    @Inject NowScreen.Presenter mPresenter;

    @InjectView(R.id.current_temp) TextView mCurrentTemp;
    @InjectView(R.id.text_current_weather) TextView mWeatherText;
    @InjectView(R.id.attribution) TextView mAttribution;
    private LineGraphView mLineGraph;

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
        mLineGraph = ((LineGraphHolder)findViewById(R.id.graph)).getLineGraphView();
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
                GraphViewSeriesStyle style = new GraphViewSeriesStyle();
                style.thickness = (int) resources.getDimension(R.dimen.graph_stroke_width);
                style.color = resources.getColor(R.color.theme_accent);
                mLineGraph.addSeries(new GraphViewSeries("Hello", style, rainSummary.getData()));

            }
        });
        mPresenter.takeView(this);
    }

    // GraphView's api is terrible
    private void setUpGraph(Resources resources) {
        GraphViewStyle graphStyle = mLineGraph.getGraphViewStyle();
        graphStyle.setGridStyle(GraphViewStyle.GridStyle.HORIZONTAL);
        graphStyle.setHorizontalLabelsColor(resources.getColor(R.color.text_primary));
        graphStyle.setVerticalLabelsColor(resources.getColor(R.color.text_primary));
        graphStyle.setVerticalLabelsAlign(Paint.Align.LEFT);
        graphStyle.setTextSize(resources.getDimension(R.dimen.text_size_xsmall));
        mLineGraph.setVerticalLabels(resources.getStringArray(R.array.graph_labels_vert));
        mLineGraph.setHorizontalLabels(resources.getStringArray(R.array.graph_labels_horiz));
        mLineGraph.setManualYAxisBounds(0, 0.5);
        mLineGraph.setDisableTouch(true);
        mLineGraph.setBackgroundColor(resources.getColor(R.color.theme_accent_light));
        mLineGraph.setDrawBackground(true);
    }

    @Override protected void onDetachedFromWindow() {
        mPresenter.dropView(this);
        super.onDetachedFromWindow();
    }
}
