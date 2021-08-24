package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class BroadcastReceiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
    }

    public void broadcastIntent(View view) {
        Log.d("Action: ", "button clicked");
        Intent intent = new Intent();
        intent.setAction("com.learnandroid.custom_intent");
        sendBroadcast(intent);
        Log.d("Curious: ", "Did it reach here first?");
    }
}