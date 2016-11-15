package com.example.leeseungyun.mylogger2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends Activity {
    public GetGPS GPS ;
    ArrayList<Double> arr_lat = new ArrayList();
    ArrayList<Double> arr_lon = new ArrayList();
    ArrayList<String> arr_str = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DataList datall = new DataList();
        GPS = new GetGPS(MainActivity.this);
        //GPS.checkDangerousPermissions();

        final TextView lontext = (TextView) findViewById(R.id.lontext);
        final TextView lattext = (TextView) findViewById(R.id.lattext);
        final TextView acctext = (TextView) findViewById(R.id.acctext);
        Button gpscall = (Button) findViewById(R.id.gpscall);
        Button mapcall = (Button) findViewById(R.id.mapview);
        Button record = (Button) findViewById(R.id.button3);
        Button reset = (Button) findViewById(R.id.reset);
        final EditText inputtext = (EditText) findViewById(R.id.editText);

        gpscall.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        GPS.getLocation();
                        double lat = GPS.getLatitude();
                        double lon = GPS.getLongitude();
                        float accuracy = GPS.getAccuracy();
                        lontext.setText("경도 : "+String.valueOf(lon));
                        lattext.setText("위도 : "+String.valueOf(lat));
                        acctext.setText("신뢰도 : "+String.valueOf(accuracy)+"(반경"+String.valueOf(accuracy)+"m 안에 있음)");
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

        record.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        GPS.getLocation();
                        double lat = GPS.getLatitude();
                        double lon = GPS.getLongitude();
                        String str = inputtext.getText().toString();
                        datall.arr_lat.add(lat);
                        datall.arr_lon.add(lon);
                        datall.arr_str.add(str);
                        inputtext.setText("");
                    }
                }
        );

        reset.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        datall.arr_lat.clear();
                        datall.arr_lon.clear();
                        datall.arr_str.clear();
                        Toast.makeText(getApplicationContext(), "저장된 정보가 모두 삭제 되었습니다.",LENGTH_SHORT).show();
                    }
                }
        );
    }

}
