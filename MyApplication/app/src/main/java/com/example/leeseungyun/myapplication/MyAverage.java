package com.example.leeseungyun.myapplication;

/**
 * Created by Lee Seung Yun on 2016-09-29.
 */
public class MyAverage extends MyValues {
    public MyAverage(){
        number[0] = 1;
    }
    public int getResult(){
        int result=0;

        for(int i = 1 ; i < number[0] ; i++)
        {
            result += number[i];
        }
        result /= (number[0]-1);
        return result;
    }
}
