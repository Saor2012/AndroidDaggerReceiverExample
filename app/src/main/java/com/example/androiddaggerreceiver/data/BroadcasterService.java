package com.example.androiddaggerreceiver.data;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.example.androiddaggerreceiver.presentation.IMainPresenter;

import javax.inject.Inject;

import dagger.android.DaggerBroadcastReceiver;
import timber.log.Timber;

public class BroadcasterService extends DaggerBroadcastReceiver {
//    @Inject
    private IMainPresenter.View view;
    private final int REQUEST_CODE = 1004;
    private final String RESULT_CODE = "REQUEST_CODE";
    private final String REQUEST_ACTION_CONTEXT = "REQUEST_ACTION_CONTEXT";
    private final String REQUEST_ACTION_VALUE = "REQUEST_ACTION_VALUE";
    private final String RESULT_ACTION_CONTEXT = "RESULT_ACTION_CONTEXT";
    private final String RESULT_ACTION_VALUE = "RESULT_ACTION_VALUE";
    private final String REQUEST_CODE_GPS = "GPS_LOCATION";
    private final String PACKEGE_SERVICE = "com.example.androiddaggerservice";

//    @Inject


    public BroadcasterService(IMainPresenter.View view) {
        this.view = view;
        Timber.e("Call constructor");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Timber.e("Call onReceive()");
//        String action = intent.getAction();
//        int code = intent.getIntExtra(RESULT_CODE, 0);

//        if(Intent.ACTION_BOOT_COMPLETED.equals(action)) {
//            Timber.tag("BroadcasterService").e("In onReceive");
//            view.toast( "Boot compleated");
//        }
//
//        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
//            boolean isConnectivity = intent.getBooleanExtra(ConnectivityManager.CONNECTIVITY_ACTION, false);
//            if (isConnectivity) {
//                Timber.e("Disconnected");
//                view.toast( "Disconnected");
//            } else {
//                Timber.e("Connected");
//                view.toast( "Connected");
//            }
//        }

//        if(code == REQUEST_CODE) {
//            if(intent != null && intent.getStringExtra(RESULT_ACTION_VALUE) != null) {
//                String responce = intent.getStringExtra(RESULT_ACTION_VALUE);
//                Timber.tag("BroadcasterService").e("responce");
//                view.viewCoords(getGPSCoords(responce));
//            }
//        }

        if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
            Timber.e("Ok battery");
            view.toast( "Ok battery");
        }

        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE );
        NetworkInfo activeNetInfo = null;
        if (connectivityManager != null) {
            activeNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        }
        boolean isConnected = activeNetInfo != null && activeNetInfo.isConnectedOrConnecting();
        if (isConnected) {
            Timber.e("Internet connected");
            view.toast( "Internet connected");
        } else {
            Timber.e("Internet disconnected");
            view.toast( "Internet disconnected");
        }

        if (PACKEGE_SERVICE.equals(intent.getAction()) || "location_update".equals(intent.getAction())) {
            if (intent.getStringExtra(REQUEST_CODE_GPS).equals(REQUEST_CODE_GPS)) {
                String coords = intent.getStringExtra(REQUEST_CODE_GPS);
                view.viewCoords(coords);
            }
        }
    }

//    public String[] getGPSCoords(String responce) {
//        if (!responce.equals("")) {
//            String[] arr = responce.split("||");
//            if (!arr[0].equals("")) {
//                arr[0] = "-1";
//                arr[1] = "-1";
//                return arr;
//            } else return arr;
//        }
//        return new String[0];
//    }
}
