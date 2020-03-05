package com.example.androiddaggerreceiver.presentation;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

import javax.inject.Inject;

import timber.log.Timber;

public class MainPresenter implements IMainPresenter.Presenter{
    @Inject
    IMainPresenter.View view;
    private final String REQUEST_CODE_GPS = "GPS_LOCATION";

    @Inject
    public MainPresenter() {}

    @Override
    public void detachView() {
        if (view != null) view = null;
    }

    @Override
    public void startView(IMainPresenter.View view) {}

    @Override
    public void init() {}

    @Override
    public void sendQuery() {
        Timber.e("Start intent presenter");
        if (view != null) {
            view.sendQuery(REQUEST_CODE_GPS);
        }
    }
}
