package com.osacky.umbrella.ui.forecast;

import android.content.Context;
import android.util.AttributeSet;

import com.osacky.umbrella.widget.RecycleListView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import mortar.Mortar;
import retrofit.RetrofitError;
import rx.RetrofitObserver;

public class ForecastView extends RecycleListView {

    @Inject ForecastScreen.Presenter mPresenter;

    public ForecastView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            Mortar.inject(context, this);
            setAdapter(mPresenter.getForecastAdapter());
        }
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) return;
        ButterKnife.inject(this);

        mPresenter.getSubscription(new RetrofitObserver<ForecastWeatherSummary>() {
            @Override public void onRetrofitError(RetrofitError e) {
                setListShown(true);
            }

            @Override public void onNext(ForecastWeatherSummary rainSummary) {
                setListShown(true);
            }
        });
        mPresenter.takeView(this);
    }

    @Override protected void onDetachedFromWindow() {
        mPresenter.dropView(this);
        super.onDetachedFromWindow();
    }
}
