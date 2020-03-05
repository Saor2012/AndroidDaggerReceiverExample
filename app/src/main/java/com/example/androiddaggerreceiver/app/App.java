package com.example.androiddaggerreceiver.app;

import android.annotation.SuppressLint;

import com.example.androiddaggerreceiver.BuildConfig;
import com.example.androiddaggerreceiver.data.di.component.DaggerAppDaggerComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import timber.log.Timber;

@SuppressLint("Registered")
public class App extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppDaggerComponent.builder().create(this);
    }
}
