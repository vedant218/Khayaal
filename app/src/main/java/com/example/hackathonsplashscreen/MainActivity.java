package com.example.hackathonsplashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.location.FusedLocationProviderClient;

public class MainActivity extends AppCompatActivity {
    private static final String NOTIFICATION_CHANNEL_ID = "10001";
    String default_notification_channel_id = "Default";
    LottieAnimationView lottie;
    double lat,lng;
    String laty,longy;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int Request_code = 101;
    String home = "Mumbai";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.getApplicationContext());
//
//        getCurrentLocation();

        //bg = findViewById(R.id.imageView5);
        lottie = findViewById(R.id.animation_view);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent i = new Intent(MainActivity.this, loginscreen1.class);
                startActivity(i);
                finish();
            }
        }, 3000);

        createNotification();
    }
    private void createNotification () {
        NotificationManager mNotificationManager = (NotificationManager)getSystemService( NOTIFICATION_SERVICE ) ;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext() , default_notification_channel_id ) ;
        mBuilder.setContentTitle("Location Alert!:" ) ;
        mBuilder.setContentText( "The user is at home! " ) ;
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

//    private void getCurrentLocation() {
//
//        if (ActivityCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
//
//            ActivityCompat.requestPermissions
//                    (this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},Request_code);
//            return;
//
//        }
//        com.google.android.gms.location.LocationRequest locationRequest = com.google.android.gms.location.LocationRequest.create();
//        //locationRequest.setInterval(60000);
//        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        LocationCallback locationCallback = new LocationCallback() {
//            @Override
//            public void onLocationResult(@NonNull LocationResult locationResult) {
//
//                if (locationRequest == null){
//                    return;
//                }
//                for (Location location:locationResult.getLocations()){
//                    if (location !=null){
//
//                    }
//                }
//            }
//        };
//
//        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback, null);
//
//        Task<Location> task = fusedLocationProviderClient.getLastLocation();
//        task.addOnSuccessListener(new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//                if (location != null){
//                    lat = location.getLatitude();
//                    lng = location.getLongitude();
//                    Geocoder geocoder;
//                    List<Address> addresses;
//                    geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
//                    try {
//                        addresses = geocoder.getFromLocation(lat, lng, 1);
//                        String city = addresses.get(0).getLocality();
//                        textView1.setText(city);
//                        if (city != "mumba")
//                            createNotification();
//
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (Request_code){
//            case Request_code:
//                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    getCurrentLocation();
//                }
//        }
//
//
//    }
//
//    @Override
//    public void onLocationChanged(@NonNull Location location) {
//
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//    private void createNotification () {
//        NotificationManager mNotificationManager = (NotificationManager)getSystemService( NOTIFICATION_SERVICE ) ;
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext() , default_notification_channel_id ) ;
//        mBuilder.setContentTitle( "My Notification" ) ;
//        mBuilder.setContentText( "Notification Listener Service Example" ) ;
//        mBuilder.setTicker( "Notification Listener Service Example" ) ;
//        mBuilder.setSmallIcon(R.drawable. ic_launcher_foreground ) ;
//        mBuilder.setAutoCancel( true ) ;
//        if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {
//            int importance = NotificationManager. IMPORTANCE_HIGH ;
//            NotificationChannel notificationChannel = new NotificationChannel( NOTIFICATION_CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance) ;
//            mBuilder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
//            assert mNotificationManager != null;
//            mNotificationManager.createNotificationChannel(notificationChannel) ;
//        }
//        assert mNotificationManager != null;
//        mNotificationManager.notify(( int ) System. currentTimeMillis () , mBuilder.build()) ;
//    }

    // bg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
    }
