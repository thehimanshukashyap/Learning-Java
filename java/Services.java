package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Log.d("Android: ", "onCreate() callback");
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }


    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}