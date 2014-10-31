package com.osacky.umbrella.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public enum  NetworkState {
    CONNECTED,
    DISCONNECTED;

    public static NetworkState get(Context paramContext) {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService(CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
            return CONNECTED;
        } else {
            return DISCONNECTED;
        }
    }

    static Observable<NetworkState> observable(final Context paramContext) {
        return Observable.create(new Observable.OnSubscribe<NetworkState>() {
            public void call(final Subscriber<? super NetworkState> paramAnonymousSubscriber) {
                final BroadcastReceiver local1 = new BroadcastReceiver() {
                    public void onReceive(Context paramAnonymous2Context, Intent paramAnonymous2Intent) {
                        if (CONNECTIVITY_ACTION.equals(paramAnonymous2Intent.getAction()))
                            paramAnonymousSubscriber.onNext(NetworkState.get(paramAnonymous2Context));
                    }
                };
                paramAnonymousSubscriber.onNext(NetworkState.get(paramContext));
                paramContext.registerReceiver(local1, new IntentFilter(CONNECTIVITY_ACTION));
                paramAnonymousSubscriber.add(Subscriptions.create(new Action0() {
                    public void call() {
                        paramContext.unregisterReceiver(local1);
                    }
                }));
            }
        }).distinctUntilChanged();
    }
}
