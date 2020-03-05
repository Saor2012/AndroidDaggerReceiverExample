package com.example.androiddaggerreceiver.data.di.modules;

import com.example.androiddaggerreceiver.presentation.IMainPresenter;
import com.example.androiddaggerreceiver.presentation.MainActivity;
import com.example.androiddaggerreceiver.presentation.MainPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {
    @Binds
    abstract IMainPresenter.View bindMainView(MainActivity view);

    @Binds
    abstract IMainPresenter.Presenter bindMainPresenter(MainPresenter presenter);
}
