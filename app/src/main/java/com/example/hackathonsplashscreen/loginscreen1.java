package com.example.hackathonsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginscreen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen1);

        Button patient = findViewById(R.id.patient);
        patient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent patientIntent = new Intent(getApplicationContext(), patient.class);
                startActivity(patientIntent);
            }

        });
    }
}