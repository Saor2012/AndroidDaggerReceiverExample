package com.example.androiddaggerreceiver.presentation;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

import javax.inject.Inject;

public class MainPresenter implements IMainPresenter.Presenter{
    @Inject
    IMainPresenter.View view;

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
        if (image != null){

            view.sendQuery(byteArray);
        } else {
            view.toast("Error image null method send Presenter");
        }
    }
}
