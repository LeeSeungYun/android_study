package com.example.leeseungyun.recordlocation;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;

public class GpsCall extends Service implements LocationListener {
    private final Context mContext;
    boolean isGPS = false;
    boolean isNetwork = false;
    boolean isGetLocation = false;

    Location location;
    double lat = 0; //위도
    double lon = 0; //경도

    private static final long UPDATE_TIME = 1;
    private static final long UPDATE_DISTANCE = 1;

    protected LocationManager locationManager;

    public GpsCall(Context context) {
        this.mContext = context;
        getLocation();
    }

    public Location getLocation() {
        try {
            locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
            //GPS정보 가져오기
            isGPS = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
            //현재 네트워트 상태 값
            isNetwork = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            this.isGetLocation = true;

            if (isNetwork) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, UPDATE_TIME,UPDATE_DISTANCE, this);
                if (locationManager != null) {
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    if (location != null) {
                        lat = location.getLatitude();
                        lon = location.getLongitude();
                    }
                }
            }

          if(isGPS){
                if(location == null){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,UPDATE_TIME,UPDATE_DISTANCE,this);
                    if(locationManager != null){location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if(location != null){
                            lat = location.getLatitude();
                            lon = location.getLongitude();
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return location;
    }

    public void stopGPS(){
        if(locationManager != null) {
//            locationManager.removeUpdates(GpsCall.this);
        }
    }

    public double getLatitude(){
        if(location != null){
            lat = location.getLatitude();
        }
        return lat;
    }

    public double getLongitude(){
        if(location != null){
            lon = location.getLongitude();
        }
        return lon;
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }

    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub

    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }

    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }
}