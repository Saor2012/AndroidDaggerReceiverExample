package com.example.androiddaggerreceiver.data.di.component;

import com.example.androiddaggerreceiver.app.App;
import com.example.androiddaggerreceiver.data.di.modules.ApplicationModule;
import com.example.androiddaggerreceiver.data.di.modules.BuildersModuleActivity;
import com.example.androiddaggerreceiver.data.di.modules.BroadcastReceiverModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
    ApplicationModule.class,
    BuildersModuleActivity.class,
    BroadcastReceiverModule.class})
public interface AppDaggerComponent extends AndroidInjector<App> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App>{}
}
