package com.example.androiddaggerreceiver.data;

import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import dagger.android.DaggerService;

public class ServicePos extends DaggerService {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
