package com.example.hackathonsplashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class homefamily extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homefamily);

        Button media = findViewById(R.id.media);
        media.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mediaIntent = new Intent(getApplicationContext(), media.class);
                startActivity(mediaIntent);

            }
        });

        Button vc = findViewById(R.id.vc);
        vc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent vcIntent = new Intent(getApplicationContext(), vc.class);
                startActivity(vcIntent);

            }
        });

        Button report= findViewById(R.id.report);
        report.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent reportIntent = new Intent(getApplicationContext(), report.class);
                startActivity(reportIntent);

            }
        });
    }
}