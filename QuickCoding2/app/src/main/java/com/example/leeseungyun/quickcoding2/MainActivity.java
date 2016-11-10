package com.example.leeseungyun.quickcoding2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bigger = (Button)findViewById(R.id.bigger);
        final Button smaller = (Button)findViewById(R.id.smaller);
        final Button bingo = (Button)findViewById(R.id.bingo);
        final Button reset = (Button)findViewById(R.id.reset);
        final TextView gametext = (TextView)findViewById(R.id.gametext);
        final EditText numberbox = (EditText)findViewById(R.id.number);

        final numbergame NumGame = new numbergame();
        final Random r = new Random();

        gametext.setText(String.valueOf(NumGame.number)+" ??");

        bigger.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        NumGame.from = NumGame.number;
                        NumGame.number = r.nextInt(NumGame.to - NumGame.from) + NumGame.from;
                        NumGame.count++;
                        gametext.setText(String.valueOf(NumGame.number) + " ??");
                    }
                }
        );

        smaller.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        NumGame.to = NumGame.number;
                        NumGame.number = r.nextInt(NumGame.to-NumGame.from)+NumGame.from;
                        NumGame.count++;
                        gametext.setText(String.valueOf(NumGame.number)+" ??");
                    }
                }
        );

        bingo.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(NumGame.number == Integer.parseInt(numberbox.getText().toString()))
                            gametext.setText(String.valueOf(NumGame.count)+" Times");
                        else
                            gametext.setText("틀리자나!!!");
                    }
                }
        );

        reset.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        NumGame.count = 0;
                        NumGame.to = 501;
                        NumGame.from = 0;
                        NumGame.number = r.nextInt(501);
                        gametext.setText(String.valueOf(NumGame.number)+" ??");
                    }
                }
        );



    }
}