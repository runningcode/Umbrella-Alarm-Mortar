package com.osacky.umbrella.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.jjoe64.graphview.LineGraphView;
import com.osacky.umbrella.util.Views;

public class LineGraphHolder extends FrameLayout {

    private final LineGraphView mLineGraphView;

    public LineGraphHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
        mLineGraphView = new LineGraphView(context, attrs);
        mLineGraphView.setId(Views.generateViewId());
        mLineGraphView.setVisibility(GONE);
        addView(mLineGraphView);
    }

    public LineGraphView getLineGraphView() {
        return mLineGraphView;
    }
}
