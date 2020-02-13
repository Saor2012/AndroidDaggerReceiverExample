package com.example.androiddaggerreceiver.presentation;


import com.example.androiddaggerreceiver.presentation.base.BasePresenter;

public interface IMainPresenter {
    interface View {
        void sendQuery(byte[] byteArray);
        void toast(String messag);
    }
    interface Presenter extends BasePresenter<View> {
        void init();
        void sendQuery();
    }
}
