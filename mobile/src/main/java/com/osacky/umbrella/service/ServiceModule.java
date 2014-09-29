package com.osacky.umbrella.service;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;

import com.osacky.umbrella.R;
import com.osacky.umbrella.UmbrellaModule;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                DailyCheckService.class,
                HourlyCheckService.class
        },
        addsTo = UmbrellaModule.class
)
public class ServiceModule {

    private Context mContext;

    ServiceModule(Context context) {
        mContext = context;
    }

    @Provides
    NotificationCompat.Builder provideNotificationBuilder(
            @Named("default") int defaults, @DrawableRes int icon) {
        return new NotificationCompat.Builder(mContext)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setSmallIcon(icon)
                .setDefaults(defaults);
    }

    @Provides @Named("default") int provideNotifDefaults() {
        return NotificationCompat.DEFAULT_ALL;
    }

    @Provides @DrawableRes int provideDrawableRes() {
        return R.drawable.ic_stat_rain;
    }
}
