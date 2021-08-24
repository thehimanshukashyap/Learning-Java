package com.example.learnandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Action: ", "Broadcast received");
        Toast.makeText(context, "Intent Detected!", Toast.LENGTH_LONG).show();
    }
}
