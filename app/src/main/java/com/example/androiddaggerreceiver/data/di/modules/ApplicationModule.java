package com.example.androiddaggerreceiver.data.di.modules;

import android.content.Context;

import com.example.androiddaggerreceiver.app.App;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ApplicationModule {
    @Singleton
    @Binds
    abstract Context provideContext(App app);
}