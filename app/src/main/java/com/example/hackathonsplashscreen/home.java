package com.example.hackathonsplashscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class home extends AppCompatActivity {

    Button button1;
    Button button2;

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    CareFragment careFragment = new CareFragment();
    TimeFragment timeFragment = new TimeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button1 = findViewById(R.id.bot);
        button2 = findViewById(R.id.voice);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent patientIntent = new Intent(getApplicationContext(), patient.class);
                startActivity(patientIntent);
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Audio.class);
                startActivity(intent);
            }

        });

        bottomNavigationView= findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.Caretaker:
                        Intent intent = new Intent(getApplicationContext(), CalActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.timeline:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,timeFragment).commit();
                        return true;

                }
                return false;
            }
        });
    }
}