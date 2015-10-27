package com.example.testeParcelable;

import android.util.Log;

/**
 * Created by C047437 on 27/10/2015.
 */
public class Util {

    static void Log(String data){
        String json = data;
        int length = json.length();

        for(int i=0; i<length; i+=1024)
        {
            if(i+1024<length)
                Log.d("OUTPUT", json.substring(i, i + 1024));
            else
                Log.d("OUTPUT", json.substring(i, length));
        }
    }
}
