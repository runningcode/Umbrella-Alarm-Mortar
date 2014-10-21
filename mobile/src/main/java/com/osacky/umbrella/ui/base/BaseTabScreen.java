package com.osacky.umbrella.ui.base;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.MenuItem;

import com.osacky.umbrella.R;
import com.osacky.umbrella.core.CorePresenter;
import com.osacky.umbrella.core.anim.Transition;
import com.osacky.umbrella.core.util.BetterViewPresenter;
import com.osacky.umbrella.core.util.StateBlueprint;
import com.osacky.umbrella.core.util.TransitionScreen;
import com.osacky.umbrella.data.api.ForecastWeatherManager;
import com.osacky.umbrella.data.api.model.RainSummary;
import com.osacky.umbrella.data.api.model.WeatherResult;
import com.osacky.umbrella.service.WeatherToSummary;
import com.osacky.umbrella.ui.notifications.NotificationsScreen;
import com.osacky.umbrella.util.ObjectUtils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Flow;
import flow.Layout;
import retrofit.RetrofitError;
import rx.Observable;
import rx.RetrofitObserver;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import timber.log.Timber;

@Layout(R.layout.view_base_weather)
@Transition({R.animator.slide_in_right, R.animator.slide_out_left, R.animator.slide_in_left, R.animator.slide_out_right})
public class BaseTabScreen extends TransitionScreen implements StateBlueprint {

    private SparseArray<Parcelable> mViewState;

    @Override public void setViewState(SparseArray<Parcelable> viewState) {
        mViewState = viewState;
    }

    @Override public String getMortarScopeName() {
        return ObjectUtils.getClass(this).getName();
    }

    @Override public Object getDaggerModule() {
        return new Module(mViewState);
    }

    @dagger.Module(
            injects = BaseTabView.class,
            addsTo = CorePresenter.Module.class,
            library = true
    )
    public static class Module {
        private final SparseArray<Parcelable> viewState;

        public Module(SparseArray<Parcelable> viewState) {
            this.viewState = viewState;
        }

        @Provides @Named("tabs") SparseArray<Parcelable> providesViewState() {
            return viewState;
        }
    }

    @Singleton
    public static class Presenter extends BetterViewPresenter<BaseTabView> {

        private final Flow mFlow;
        private final Observable<WeatherResult> mObservable;

        @Inject
        public Presenter(@Named("tabs") SparseArray<Parcelable> viewState,
                         Provider<Location> locationProvider,
                         ForecastWeatherManager weatherManager,
                         WeatherToSummary weatherToSummary,
                         final Flow flow
        ) {
            super(viewState);
            mFlow = flow;
            Location location = locationProvider.get();
            if (location == null) {
                mObservable = Observable.empty();
                // TODO do something
                Timber.e("Location was null");
                return;
            }
            mObservable = weatherManager.get(location.getLatitude(), location.getLongitude());
            mObservable.map(weatherToSummary)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(new Action1<RainSummary>() {
                        @Override public void call(RainSummary rainSummary) {
                            if (rainSummary == null) return;
                            getView().setTitle(rainSummary.getCityName());
                        }
                    })
                    .subscribe(new RetrofitObserver<RainSummary>() {
                        @Override public void onRetrofitError(RetrofitError e) {}
                        @Override public void onNext(RainSummary rainSummary) {}
                    });
        }

        @Override public void onLoad(Bundle savedInstanceState) {
            super.onLoad(savedInstanceState);
            getView().setMenu(R.menu.about, new Toolbar.OnMenuItemClickListener() {
                @Override public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.about:
                            return true;
                        case R.id.notification:
                            mFlow.goTo(new NotificationsScreen());
                            return true;
                    }
                    return false;
                }
            });
        }

        public Observable<WeatherResult> getObservable(){
            return mObservable;
        }
    }
}
