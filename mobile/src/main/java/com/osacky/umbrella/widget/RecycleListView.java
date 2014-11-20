package com.osacky.umbrella.widget;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.osacky.umbrella.R;

public class RecycleListView extends FrameLayout {

    private boolean mListShown;

    private final RecyclerView mRecyclerView;
    private final View mProgress;
    private final View mListContainer;

    public RecycleListView(Context context) {
        this(context, null);
    }

    public RecycleListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecycleListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflate(context, R.layout.recycle_list_view, this);

        mRecyclerView = (RecyclerView) findViewById(android.R.id.list);
        mProgress = findViewById(R.id.recycle_progress);
        mListContainer = findViewById(R.id.list_container);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        mListShown = false;
    }

    public void setAdapter(RecyclerView.Adapter<?> adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    public void setListShownNoAnimation(boolean shown) {
        setListShown(shown, false);
    }

    public void setListShown(boolean shown) {
        setListShown(shown, true);
    }

    private void setListShown(boolean shown, boolean animate) {
        if (mListShown == shown) {
            return;
        }
        mListShown = shown;
        if (shown) {
            if (animate) {
                mProgress.startAnimation(AnimationUtils.loadAnimation(
                        getContext(), android.R.anim.fade_out));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getContext(), android.R.anim.fade_in));
            } else {
                mProgress.clearAnimation();
                mListContainer.clearAnimation();
            }
            mProgress.setVisibility(GONE);
            mListContainer.setVisibility(VISIBLE);
        } else {
            if (animate) {
                mProgress.startAnimation(AnimationUtils.loadAnimation(
                        getContext(), android.R.anim.fade_in));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getContext(), android.R.anim.fade_out));
            } else {
                mProgress.clearAnimation();
                mListContainer.clearAnimation();
            }
            mProgress.setVisibility(View.VISIBLE);
            mListContainer.setVisibility(View.GONE);
        }
    }
}
