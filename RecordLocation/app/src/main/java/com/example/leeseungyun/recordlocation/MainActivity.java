package com.example.leeseungyun.recordlocation;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtLat;
    private TextView txtLon;
    private Button gpsbutton;

    private GpsCall gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLat = (TextView)findViewById(R.id.lat);
        txtLon = (TextView)findViewById(R.id.lon);
        gpsbutton = (Button)findViewById(R.id.gpscall);

        gps = new GpsCall(MainActivity.this);

        gpsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //SystemClock.sleep(5*1000);
            if (gps.isGetLocation) {
                double latitude = gps.getLatitude();
                double longitude = gps.getLongitude();

                txtLat.setText(String.valueOf(latitude));
                txtLon.setText(String.valueOf(longitude));

                Toast.makeText(getApplicationContext(),
                        "위도 : " + latitude + "경도 : " + longitude,
                        Toast.LENGTH_LONG).show();
            }
            }
        });
    }

}
