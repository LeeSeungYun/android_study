package com.example.leeseungyun.mylogger2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends Activity {
    public GetGPS GPS ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GPS = new GetGPS(MainActivity.this);
        //GPS.checkDangerousPermissions();

        final TextView lontext = (TextView) findViewById(R.id.lontext);
        final TextView lattext = (TextView) findViewById(R.id.lattext);
        Button gpscall = (Button) findViewById(R.id.gpscall);
        Button mapcall = (Button) findViewById(R.id.mapview);
        Button record = (Button) findViewById(R.id.button3);
        EditText inputtext = (EditText) findViewById(R.id.editText);

        gpscall.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        //double lat = GPS.getLatitude();
                       // double lon = GPS.getLongitude();
                        //lontext.setText("경도 : "+String.valueOf(lon));
                        //lattext.setText("위도 : "+String.valueOf(lat));

                    }
                }
        );

        mapcall.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent it = new Intent (getApplicationContext(), MapView.class);
                        startActivity(it);
                    }
                }
        );
    }
//    public void onClick(View v){
//        Intent it = new Intent(this,MapView.class);
//        startActivity(it);
//    }
}
