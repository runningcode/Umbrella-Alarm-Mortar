package com.osacky.umbrella;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;

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
