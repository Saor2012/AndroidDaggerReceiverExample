package com.example.androiddaggerreceiver.data.di.modules;

import android.content.BroadcastReceiver;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BroadcastReceiverModule {
    @ContributesAndroidInjector()
    abstract BroadcastReceiver bindBroadcastReceiver();


}
