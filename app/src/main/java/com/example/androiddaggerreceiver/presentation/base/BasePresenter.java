package com.example.androiddaggerreceiver.presentation.base;

public interface BasePresenter<V> {
    void detachView();
    void startView(V view);
}
