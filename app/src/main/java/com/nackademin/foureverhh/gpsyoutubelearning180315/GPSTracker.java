package com.nackademin.foureverhh.gpsyoutubelearning180315;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by foureverhh on 2018-03-15.
 */

//To continuously update location

public class GPSTracker extends Service implements LocationListener {

    private final Context mContext;
    boolean isGpsEnabled = false;      //To show whether Gps is enabled
    boolean isNetworkEnabled = false;   //To show whether network is enabled
    boolean canGetLocation = false;     //To show whether location can be get

    Location location;
    double latitude;
    double longitude;

    private static final long MIN_DISTANCE_FOR_UPDATE = 10; //Every 10 meters would be checked
    private static final long MIN_TIME_BW_UPDATE = 1000*60*1; //Every 1 minute update
    protected LocationManager locationManager;

    public GPSTracker(Context context) {
        this.mContext = context;
        getLocation(); //  To check whether Gps is enabled, whether network is enabled, and permission is enabled
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
