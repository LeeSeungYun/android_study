package com.example.leeseungyun.mylogger2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Lee Seung Yun on 2016-11-15.
 */
public class Statistics extends FragmentActivity{
    GoogleMap gmap;
    MarkerOptions marker;
    LatLng location = new LatLng(37.559603, 126.982203);
    CameraPosition cp = new CameraPosition.Builder().target(location).zoom(11).build();


    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_map);
        DataList datall = new DataList();

        gmap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        gmap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));

        for(int i = 0 ; i < datall.arr_str.size() ; i++){
            LatLng location = new LatLng(datall.arr_lat.get(i),datall.arr_lon.get(i));
            switch(datall.arr_ran.get(i)){
                case 1:
                    marker = new MarkerOptions().position(location).title(datall.arr_str.get(i)).
                            icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                    break;
                case 2:
                    marker = new MarkerOptions().position(location).title(datall.arr_str.get(i)).
                            icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                    break;
                case 3:
                    marker = new MarkerOptions().position(location).title(datall.arr_str.get(i)).
                            icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                    break;
                case 4:
                    marker = new MarkerOptions().position(location).title(datall.arr_str.get(i)).
                            icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
                    break;
                default:
                    marker = new MarkerOptions().position(location).title(datall.arr_str.get(i)).
                            icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            }
            gmap.addMarker(marker);
        }
    }

}
