package com.example.hackathonsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class patient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(getApplicationContext(), home.class);
                startActivity(homeIntent);

                Button arrow = findViewById(R.id.arrow);
                arrow.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent loginscreen1Intent = new Intent(getApplicationContext(), loginscreen1.class);
                        startActivity(loginscreen1Intent);
                    }
                });
            }
        });
    }
}