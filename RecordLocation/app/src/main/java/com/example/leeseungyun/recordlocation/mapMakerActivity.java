package com.example.leeseungyun.recordlocation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by Lee Seung Yun on 2016-10-31.
 */
public class mapMakerActivity extends FragmentActivity{
    GoogleMap gmap;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.mapmaker);
        gmap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

    }

    public void onClick(View v){
        finish();
    }
}
