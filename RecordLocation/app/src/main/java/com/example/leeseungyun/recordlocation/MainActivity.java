package com.example.leeseungyun.recordlocation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends Activity {
    private TextView txtLat;
    private TextView txtLon;
    private Button gpsbutton;
    private Button mapbutton;
    GoogleMap mGoogle;

    private GpsCall gps;



    MapView map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ;
        txtLat = (TextView)findViewById(R.id.lat);
        txtLon = (TextView)findViewById(R.id.lon);

        gpsbutton = (Button)findViewById(R.id.gpscall);
        mapbutton = (Button)findViewById(R.id.mapbutton);

        gps = new GpsCall(MainActivity.this);

        gpsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //SystemClock.sleep(5*1000);
                if (gps.isGetLocation) {
                double latitude = gps.getLatitude();
                double longitude = gps.getLongitude();

                txtLat.setText("위도 : "+String.valueOf(latitude));
                txtLon.setText("경도 : "+String.valueOf(longitude));

                Toast.makeText(getApplicationContext(),
                        "위도 : " + latitude + " 경도 : " + longitude,
                        Toast.LENGTH_LONG).show();
                }
            }
        });

//        mapbutton.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                if(gps.isGetLocation){
//                    double latitude = gps.getLatitude();
//                    double longitude = gps.getLongitude();
//
//                    String location = "geo:";
//                    location = location + String.valueOf(latitude)+","+String.valueOf(longitude);
//
//                    Uri uri = Uri.parse("geo:37.511545,126.997297");
//                    //반포한강공원:37.511545, 126.997297
//                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//                    startActivity(intent);
//                }
//            }
//        });
    }

    public void onClick(View v){
        Intent it = new Intent(this,mapMakerActivity.class);
        startActivity(it);
    }

}
