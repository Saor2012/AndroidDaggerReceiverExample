package com.example.androiddaggerreceiver.data.di.modules;

import com.example.androiddaggerservice.data.ServicePos;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ServiceModule {
    @Singleton
    @Binds
    abstract ServicePos bindServicePos(ServicePos servicePos);
}
