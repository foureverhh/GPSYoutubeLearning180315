package com.nackademin.foureverhh.gpsyoutubelearning180315;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//Build vehicles Gps App like Uber in Android Studio Tutorial

public class MainActivity extends AppCompatActivity {

    GPSTracker gps;
    Button btnShowLocation;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    TextView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //If do not have permission send requestPermissons()
            if(ActivityCompat.checkSelfPermission(this,mPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{mPermission},REQUEST_CODE_PERMISSION);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        btnShowLocation = findViewById(R.id.button);
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(MainActivity.this); //MainActivity.this means the activity context of MarinActivity
                location = findViewById(R.id.locationText);
                //When can get location show the longitude and latitude otherwise show alert
                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    location.setText(latitude+" "+longitude);
                }else{
                    gps.showSettingsAlert();
                }
            }
        });
    }
}
