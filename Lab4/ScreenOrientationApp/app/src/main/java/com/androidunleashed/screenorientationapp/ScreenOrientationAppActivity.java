package com.androidunleashed.screenorientationapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ScreenOrientationAppActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_orientation_app);
        if(getResources().getDisplayMetrics().widthPixels>getResources().getDisplayMetrics().
            heightPixels) 
        {  
            Toast.makeText(this,"Screen switched to Landcape mode",Toast.LENGTH_SHORT).show(); 
        } 
        else 
        { 
            Toast.makeText(this,"Screen switched to Portrait mode",Toast.LENGTH_SHORT).show(); 
        }
    }
}
