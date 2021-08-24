package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WorkingWithIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_with_intent);

        Button btn_browse = (Button) findViewById(R.id.btn_browser);
        Button btn_dial = (Button) findViewById(R.id.btn_dial);

        btn_browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Action: ", "Opening Browser");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });

        btn_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Action: ", "Opening Phone App");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:8140244500"));
                startActivity(intent);
            }
        });
    }
}