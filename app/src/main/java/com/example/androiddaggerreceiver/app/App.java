package com.example.androiddaggerreceiver.app;


import com.example.androiddaggerservice.data.di.component.DaggerAppDaggerComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class App extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppDaggerComponent.builder().create(this);
    }
}
