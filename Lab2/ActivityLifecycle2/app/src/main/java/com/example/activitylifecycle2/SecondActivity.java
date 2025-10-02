package com.example.activitylifecycle2;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("Status: ", "SecondActivity:onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Status: ", "SecondActivity:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Status: ", "SecondActivity:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Status: ", "SecondActivity:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Status: ", "SecondActivity:onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Status: ", "SecondActivity:onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Status: ", "SecondActivity:onDestroy");
    }
}