package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LearnSharedPreferences extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_shared_preferences);

        sharedPreferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);


        EditText nameField = findViewById(R.id.txtName);
        EditText emailField = findViewById(R.id.txtEmail);
        Button submit = findViewById(R.id.submitDetails);
        Button viewDetails = findViewById(R.id.viewDetails);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                String email = emailField.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.putString("email", email);
                editor.apply();
                Toast.makeText(LearnSharedPreferences.this, "Details Saved.", Toast.LENGTH_SHORT).show();
                viewDetails.setVisibility(View.VISIBLE);
            }
        });

        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Name: " + sharedPreferences.getString("name", null);
                result += "\nEmail: " + sharedPreferences.getString("email", null);

                Toast.makeText(LearnSharedPreferences.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}