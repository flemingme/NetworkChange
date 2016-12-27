package com.fleming.chen.networkchange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * NetworkChangeBroadcast
 * Created by Fleming on 2016/12/26.
 */

public class NetworkChangeBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
//            Log.d("tag", activeNetwork.toString());
            if (activeNetwork != null && activeNetwork.isAvailable()) {
                String typeName = activeNetwork.getTypeName();
                Toast.makeText(context, "network is available, name is " + typeName, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network is disabled", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
