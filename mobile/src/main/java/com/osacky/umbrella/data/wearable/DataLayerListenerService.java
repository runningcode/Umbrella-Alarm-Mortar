package com.osacky.umbrella.data.wearable;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;
import com.osacky.umbrella.UmbrellaApplication;
import com.osacky.umbrella.data.api.model.WeatherResult;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class DataLayerListenerService extends WearableListenerService {

    @Inject Observable<WeatherResult> mWeatherResultObservable;

    private GoogleApiClient mGoogleApiClient;

    private static final String WEATHER_PATH = "/weather";
    private static final String TEMP_KEY = "temp_F";
    private static final String SUMMARY_KEY = "weather_summary";

    @Override public void onCreate() {
        Timber.i("ONCREATE");
        super.onCreate();
        UmbrellaApplication.get(this).getObjectGraph().inject(this);
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .build();
        mGoogleApiClient.connect();

        mWeatherResultObservable.observeOn(Schedulers.io())
                .subscribe(new Action1<WeatherResult>() {
                    @Override public void call(WeatherResult weatherResult) {
                        if (!mGoogleApiClient.isConnected()) {
                            ConnectionResult connectionResult = mGoogleApiClient
                                    .blockingConnect(30, TimeUnit.SECONDS);
                            if (!connectionResult.isSuccess()) {
                                Timber.e("Failed to connect to GoogleApiClient.");
                                return;
                            }
                        }
                        PutDataMapRequest dataMap = PutDataMapRequest.create(WEATHER_PATH);
                        int temp = (int) weatherResult.getCurrently().getTemperature();
                        Timber.i("Sending temp is %d weather is %s", temp,
                                weatherResult.getCurrently()
                                .getSummary());
                        dataMap.getDataMap().putInt(TEMP_KEY, temp);
                        dataMap.getDataMap().putString(SUMMARY_KEY, weatherResult.getCurrently()
                                .getSummary());

                        PutDataRequest request = dataMap.asPutDataRequest();
                        Wearable.DataApi.putDataItem(mGoogleApiClient, request).await();
                    }
                });
    }

    @Override public void onMessageReceived(MessageEvent messageEvent) {
        Timber.d("onMessageReceived: " + messageEvent);
    }

    @Override public void onPeerConnected(Node peer) {
        Timber.i("onPeerConnected %s", peer);
    }

    @Override public void onPeerDisconnected(Node peer) {
        Timber.i("onPeerDisconnected %s", peer);
    }
}
