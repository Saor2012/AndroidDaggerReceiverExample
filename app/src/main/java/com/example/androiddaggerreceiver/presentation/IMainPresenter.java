package com.example.androiddaggerreceiver.presentation;


import com.example.androiddaggerreceiver.presentation.base.BasePresenter;

public interface IMainPresenter {
    interface View {
        void sendQuery(String query);
        void toast(String messag);
        void viewCoords(String coords);
    }
    interface Presenter extends BasePresenter<View> {
        void init();
        void sendQuery();
    }
}
