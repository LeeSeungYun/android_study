package com.example.leeseungyun.mylogger2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends Activity {
    public GetGPS GPS ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkDangerousPermissions();

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
        final RadioButton study = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton eatting = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton travel = (RadioButton) findViewById(R.id.radioButton3);
        final RadioButton etc = (RadioButton) findViewById(R.id.radioButton4);
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
                        if(study.isChecked()){datall.arr_ran.add(4);}
                        if(eatting.isChecked()){datall.arr_ran.add(3);}
                        if(travel.isChecked()){datall.arr_ran.add(2);}
                        if(etc.isChecked()){datall.arr_ran.add(1);}
                        datall.arr_lat.add(GPS.getLatitude());
                        datall.arr_lon.add(GPS.getLongitude());
                        datall.arr_str.add(inputtext.getText().toString());
                        inputtext.setText("");
                    }
                }
        );

        reset.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent st = new Intent(getApplicationContext(),Statistics.class);
                        startActivity(st);
                    }
                }
        );
    }
    private void checkDangerousPermissions(){
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for(int i=0 ; i< permissions.length; i++){
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if(permissionCheck == PackageManager.PERMISSION_DENIED){
                break;
            }
        }
        if(permissionCheck == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if(ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[0])){
                Toast.makeText(this,"권한 설명 필요함.", Toast.LENGTH_LONG).show();
            }else{
                ActivityCompat.requestPermissions(this,permissions,1);
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == 1){
            for(int i=0 ; i<permissions.length ; i++){
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, permissions[i] + "권한이 승인됨.", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this,permissions[i] + "권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}
