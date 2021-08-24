package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class AndroidLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_life_cycle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Android: ", "onStart() method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Android: ", "onResume() method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Android: ", "onPause() method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Android: ", "onStop() method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Android: ", "onRestart() method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Android: ", "onDestroy() method");
    }
}