package com.example.hackathonsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //bg = findViewById(R.id.imageView5);
        lottie = findViewById(R.id.animation_view);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent i = new Intent(MainActivity.this, loginscreen1.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
    // bg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
    }
