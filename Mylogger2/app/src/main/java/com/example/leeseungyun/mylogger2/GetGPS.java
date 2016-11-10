package com.example.leeseungyun.mylogger2;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;

/**
 * Created by Lee Seung Yun on 2016-11-11.
 */
public class GetGPS extends Service implements LocationListener{
    private final Context mContext;
    double latitude = 0;
    double longitude = 0;
    Location location;
    protected LocationManager locationManager =
            (LocationManager)getSystemService(Context.LOCATION_SERVICE);

    public GetGPS(Context context){
        this.mContext = context;
        getLocation();
    }

//    public void checkDangerousPermissions() {
//        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
//
//        int permissionCheck = PackageManager.PERMISSION_GRANTED;
//        for (int i = 0; i < permissions.length; i++) {
//            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
//            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
//                break;
//            }
//        }
//        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
//            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();
//
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
//                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
//            } else {
//                ActivityCompat.requestPermissions(this, permissions, 1);
//            }
//        }
//    }
    public Location getLocation(){

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10, (android.location.LocationListener) this);
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        return location;
    }

    public double getLatitude(){
        return location.getLatitude();
    }

    public double getLongitude(){
        return location.getLongitude();
    }


    public IBinder onBind(Intent arg0) {
        return null;
    }
    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub

    }
}
