package com.fleming.chen.networkchange;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * NetworkStatusService
 * Created by Fleming on 2016/12/27.
 */

public class NetworkStatusService extends Service {

    private IntentFilter mFilter;
    private NetworkChangeBroadcastReceiver mReceiver;

    @Override
    public void onCreate() {
        super.onCreate();

        mFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        mReceiver = new NetworkChangeBroadcastReceiver();
        registerReceiver(mReceiver, mFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class NetworkChangeBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                String statusName = NetworkUtils.getNetworkStatusString(context);
                Toast.makeText(context, statusName, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
