package com.example.androiddaggerreceiver.presentation;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androiddaggerreceiver.R;
import com.example.androiddaggerreceiver.data.BroadcasterService;
import com.example.androiddaggerreceiver.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.Objects;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import timber.log.Timber;

public class MainActivity extends DaggerAppCompatActivity implements IMainPresenter.View {
    @Inject
    IMainPresenter.Presenter presenter;

//    @Inject
    private BroadcastReceiver broadcastReceiver;
    private ActivityMainBinding binding;
    private Context insertContext;
    private final int REQUEST_CODE = 1004;
    private final String REQUEST_ACTION_CONTEXT = "REQUEST_ACTION_CONTEXT";
    private final String REQUEST_ACTION_VALUE = "REQUEST_ACTION_VALUE";
    private final String RESULT_ACTION_CONTEXT = "RESULT_ACTION_CONTEXT";
    private final String RESULT_ACTION_VALUE = "RESULT_ACTION_VALUE";
    private final String REQUEST_CODE_GPS = "GPS_LOCATION";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setEvent(presenter);
        broadcastReceiver = new BroadcasterService(this);
        //Intent intent = getIntent();
        //byte[] res = intent.getByteArrayExtra(RESULT_ACTION_VALUE);

        presenter.init();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if (data != null && data.getByteArrayExtra(RESULT_ACTION_VALUE) != null){
                    //String base64 = data.getStringExtra(RESULT_ACTION);
                    byte[] response = data.getByteArrayExtra(RESULT_ACTION_VALUE);
                }
            }
        }
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(this, BroadcasterService.class);
        intent.setComponent(componentName);
        sendBroadcast(intent);
    }

    @Override
    public void sendQuery(String query) {
        if (query.equals(REQUEST_CODE_GPS)){
            startActivityForResult(new Intent()
                .setClassName("com.example.androiddaggerservice.presentation",
                        "com.example.androiddaggerservice.presentation.MainActivity")
                .putExtra(REQUEST_ACTION_VALUE, REQUEST_CODE_GPS)
                .putExtra(REQUEST_ACTION_CONTEXT, (Serializable) getApplicationContext()), REQUEST_CODE);
        }
    }

    @Override
    public void toast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void viewCoords(String coords) {
        binding.viewTextField.setText(coords);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        intentFilter.addAction("location_update");
//        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
//        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        Timber.e("Call onStart()");
        registerReceiver(broadcastReceiver, new IntentFilter("location_update"));//location_update | com.example.androiddaggerservice
        presenter.startView(this);
        presenter.init();
    }

    @Override
    protected void onDestroy() {
        Timber.e("Call onDestroy()");
        if (presenter != null){
            presenter.detachView();
            presenter = null;
        }
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        super.onDestroy();
    }
}
