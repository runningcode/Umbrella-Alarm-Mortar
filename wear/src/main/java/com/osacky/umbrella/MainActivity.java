package com.osacky.umbrella;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.Observable;
import rx.functions.Action1;
import timber.log.Timber;

public class MainActivity extends Activity {

    @InjectView(android.R.id.text1) TextView mText1;
    @InjectView(android.R.id.text2) TextView mText2;

    @Inject @Temp Observable<Integer> mTempObservable;
    @Inject @Description Observable<String> mDescriptionObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Dagger_ActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .wearableApplicationComponent(WearableApplication.get(this).getComponent())
                .build()
                .injectActivity(this);

        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mTempObservable.subscribe(new Action1<Integer>() {
            @Override public void call(Integer s) {
                Timber.i("received %d", s);
                mText1.setText(String.format(getString(R.string.temp_current), s));
            }
        });

        mDescriptionObservable.subscribe(new Action1<String>() {
            @Override public void call(String s) {
                Timber.i("received %s", s);
                mText2.setText(s);
            }
        });
    }
}
