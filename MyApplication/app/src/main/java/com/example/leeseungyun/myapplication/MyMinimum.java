package com.example.leeseungyun.myapplication;

/**
 * Created by Lee Seung Yun on 2016-09-29.
 */
public class MyMinimum extends MyValues{
    public MyMinimum(){
        number[0] = 1;
    }
    public int getResult(){
        int result = 9999999;

        for(int i = 1 ; i < number[0] ; i++)
        {
            if(number[i] < result)
                result = number[i];
        }
        return result;
    }
}
