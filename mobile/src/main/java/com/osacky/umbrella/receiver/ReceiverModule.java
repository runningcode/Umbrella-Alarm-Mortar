package com.osacky.umbrella.receiver;

import com.osacky.umbrella.UmbrellaModule;

import dagger.Module;

@Module(
        injects = BootBroadCastReceiver.class,
        addsTo = UmbrellaModule.class
)
public class ReceiverModule {
}
