package com.osacky.umbrella;

import android.app.IntentService;
import android.content.Intent;

public class UmbrellaService extends IntentService {

    public UmbrellaService() {
        super(UmbrellaService.class.getSimpleName());
    }

    @Override protected void onHandleIntent(Intent intent) {

    }
}
