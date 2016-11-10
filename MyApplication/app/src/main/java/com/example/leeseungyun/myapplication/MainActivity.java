package com.example.leeseungyun.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.maintext);
        text.setText("테스트 어플리케이션~!");
        text.setTextSize(40);

        final Button button1 = (Button)findViewById(R.id.button1);
        final Button button2 = (Button)findViewById(R.id.button2);
        final Button button3 = (Button)findViewById(R.id.button3);

        final Button button4 = (Button)findViewById(R.id.input);
        final Button min = (Button)findViewById(R.id.minimum);
        final Button avg = (Button)findViewById(R.id.average);

        final EditText edit = (EditText)findViewById(R.id.edit);

        button1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("01099.93759"));
                        //intent.setAction(Intent.ACTION_DIAL);
                        //intent.setData(Uri.parse("tel:01099392759"));
                        //Toast.makeText(getApplicationContext(), button1.getText()+" 버튼을 클릭하셨습니다.", Toast.LENGTH_SHORT).show();
                        //text.setText(button1.getText());
                        startActivity(intent);
                    }
                }
        );
        button2.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        //Toast.makeText(getApplicationContext(), button2.getText()+" 버튼을 클릭하셨습니다.", Toast.LENGTH_SHORT).show();
                        //text.setText(button2.getText());
                        //startActivity(intent);
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("smsfrom:1234"));
                        intent.setData(Uri.parse("smsto:0109939-2759"));
                        intent.putExtra("sms_body", "테스트 메세지 전송~!");
                        startActivity(intent);
                    }
                }
        );
        button3.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_WEB_SEARCH);
                        intent.putExtra(SearchManager.QUERY,"구글");
                        //Toast.makeText(getApplicationContext(), button3.getText()+" 버튼을 클릭하셨습니다.", Toast.LENGTH_SHORT).show();
                        //text.setText(button3.getText());
                        startActivity(intent);
                    }
                }
        );

        final MyMinimum resultmin = new MyMinimum();
        final MyAverage resultavg = new MyAverage();

        avg.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(getApplicationContext(),String.valueOf(resultavg.getResult()),Toast.LENGTH_SHORT).show();
                    }
                }
        );
        min.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(getApplicationContext(),String.valueOf(resultmin.getResult()),Toast.LENGTH_SHORT).show();
                    }
                }
        );
        button4.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        resultmin.number[resultmin.number[0]] = Integer.parseInt(edit.getText().toString());
                        resultavg.number[resultavg.number[0]] = Integer.parseInt(edit.getText().toString());
                        resultmin.number[0]++;
                        resultavg.number[0]++;
                        String str = "";
                        for(int i = 1 ; i < resultmin.number[0] ;i++){
                            str+="["+String.valueOf(resultmin.number[i])+"]";
                        }
                        text.setText(str);
                        edit.setText("");
                    }
                }
        );
    }
}

