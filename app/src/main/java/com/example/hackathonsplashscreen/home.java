package com.example.hackathonsplashscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class home extends AppCompatActivity {

    Button button1;
    Button button2;
    private static final String NOTIFICATION_CHANNEL_ID = "10001";
    String default_notification_channel_id = "Default";

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
                Uri uri = Uri.parse("https://www.kommunicate.io/liv     echat-demo?appId=2a62c120f98dd885f0789d7a188b51b3f&botIds=pari-fkb49&assignee=pari-fkb49");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
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
        createNotification();
    }
    private void createNotification () {
        NotificationManager mNotificationManager = (NotificationManager)getSystemService( NOTIFICATION_SERVICE ) ;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext() , default_notification_channel_id ) ;
        mBuilder.setContentTitle( "Video Call Reminder!!!" ) ;
        mBuilder.setContentText( "Hi there! Please call your family whenever possible!" ) ;
        mBuilder.setTicker( "Notification Listener Service Example" ) ;
        mBuilder.setSmallIcon(R.drawable. ic_launcher_foreground ) ;
        mBuilder.setAutoCancel( true ) ;
        if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {
            int importance = NotificationManager. IMPORTANCE_HIGH ;
            NotificationChannel notificationChannel = new NotificationChannel( NOTIFICATION_CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance) ;
            mBuilder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(notificationChannel) ;
        }
        assert mNotificationManager != null;
        mNotificationManager.notify(( int ) System. currentTimeMillis () , mBuilder.build()) ;
    }
}