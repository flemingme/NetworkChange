package com.fleming.chen.networkchange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * MyBroadcastReceiver
 * Created by Fleming on 2016/12/26.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(MainActivity.MY_FILTER)) {
            String message = getResultData();
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            setResultData("这是修改后的数据");
        }
    }
}
