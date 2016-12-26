package com.fleming.chen.networkchange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * MyBroadcastReceiver3
 * Created by Fleming on 2016/12/26.
 */

public class MyBroadcastReceiver3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(MainActivity.MY_FILTER)) {
            Toast.makeText(context, getResultData(), Toast.LENGTH_SHORT).show();
        }
    }
}
