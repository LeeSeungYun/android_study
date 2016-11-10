package com.example.leeseungyun.generics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final Gen<Integer, String> generic = new Gen<>();

        final Button input = (Button) findViewById(R.id.input);
        final Button finish = (Button) findViewById(R.id.finish);
        final TextView menual = (TextView) findViewById(R.id.textView);
        final EditText inputtext = (EditText) findViewById(R.id.inputText);
        final TextView inttext = (TextView) findViewById(R.id.input_i);
        final TextView strtext = (TextView) findViewById(R.id.input_s);
        final Button reset = (Button) findViewById(R.id.reset);

        input.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        String strvar = inputtext.getText().toString();
                        try{
                            int intvar = Integer.parseInt(strvar);
                            generic.arr_i.add(intvar);
                        }catch(Exception e){
                            generic.arr_s.add(strvar);
                        }
                        inputtext.setText("");
                    }
                }
        );

        finish.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        strtext.setText("입력된 문자열 : "+generic.arr_s);
                        inttext.setText("입력된 숫자 : "+generic.arr_i);
                    }
                }
        );

        reset.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        generic.arr_i.clear();
                        generic.arr_s.clear();
                        strtext.setText("입력된 문자열 : ");
                        inttext.setText("입력된 숫자 : ");
                    }
                }
        );

    }
}
