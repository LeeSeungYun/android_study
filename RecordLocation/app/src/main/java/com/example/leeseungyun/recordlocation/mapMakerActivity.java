package com.example.leeseungyun.recordlocation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Lee Seung Yun on 2016-10-31.
 */
public class mapMakerActivity extends FragmentActivity{
    GoogleMap gmap;
    GpsCall gps = new GpsCall(mapMakerActivity.this);
    //37.510287, 126.995436 반포한강공원
//    37.551013, 126.990898 남산공원
//    37.603308, 127.024871 길음역
//    37.609921, 126.997072 국민대
//    37.658277, 126.980850 북한산 국립공원
//    37.543619, 126.900042 선유도 한강공원
//    37.521860, 127.122825 몽촌토성
//    37.578005, 126.976905 경복궁
//    37.581007, 126.993661 창경궁
//    37.566494, 126.876740 난지한강공원
    double lat_arr[] = {37.510287,37.551013,37.603308,37.609921,37.658277,37.543619,37.521860,37.578005,37.581007,37.566494,};
    double lon_arr[] = {126.995436,126.990898,127.024871,126.997072,126.980850,126.900042,127.122825,126.976905,126.993661,126.876740,};

    LatLng location = new LatLng(37.559603, 126.982203);
    MarkerOptions marker;
    CameraPosition cp = new CameraPosition.Builder().target(location).zoom(11).build();

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.mapmaker);

        gmap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap(); //지도 띄우기
        for(int i = 0 ; i < lat_arr.length ; i++){
            location = new LatLng(lat_arr[i],lon_arr[i]);
            marker = new MarkerOptions().position(location);
            gmap.addMarker(marker);
        }
        gmap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
    }

    public void onClick(View v){
        finish();
    }
}
