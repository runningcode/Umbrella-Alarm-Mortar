package com.osacky.umbrella.ui.forecast;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.osacky.umbrella.R;
import com.osacky.umbrella.data.api.model.Condition;
import com.osacky.umbrella.util.Utils;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private List<Condition> mForecastList = Collections.emptyList();

    @Inject
    public ForecastAdapter() {
    }

    public ForecastAdapter(List<Condition> forecastList) {
        mForecastList = forecastList;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_forecast, viewGroup, false);
        return new ForecastViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder forecastViewHolder, int i) {
        final Condition condition = mForecastList.get(i);
        forecastViewHolder.mSummary.setText(condition.getIcon());
        forecastViewHolder.mDayOfWeek.setText(condition.getDateTime().dayOfWeek().getAsShortText());
        forecastViewHolder.mMiniDate.setText(Utils.formatDate(condition.getDateTime().toDate()));
        forecastViewHolder.mChanceOfRain.setText(
                String.format(forecastViewHolder.mContext.getString(R.string.chance_of_rain_mini),
                condition.getPrecipProbability()));
        forecastViewHolder.mTempHiLo.setText(
                String.format(forecastViewHolder.mContext.getString(R.string.temp_high_low),
                        (int) condition.getTemperatureMin(),
                        (int) condition.getTemperatureMax()));
    }

    @Override public int getItemCount() {
        return mForecastList.size();
    }

    public void setForecastList(List<Condition> forecastList) {
        Utils.assertUiThread();
        mForecastList = forecastList;
        notifyDataSetChanged();
    }

    protected static class ForecastViewHolder extends RecyclerView.ViewHolder {

        public final TextView mSummary;
        public final TextView mDayOfWeek;
        public final TextView mMiniDate;
        public final TextView mChanceOfRain;
        public final TextView mTempHiLo;
        public final Context mContext;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            mSummary = ButterKnife.findById(itemView, R.id.forecast_summary);
            mDayOfWeek = ButterKnife.findById(itemView, R.id.forecast_day_of_week);
            mMiniDate = ButterKnife.findById(itemView, R.id.forecast_mini_date);
            mChanceOfRain = ButterKnife.findById(itemView, R.id.forecast_chance_of_rain);
            mTempHiLo = ButterKnife.findById(itemView, R.id.forecast_hi_lo);
        }
    }
}
