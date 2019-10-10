package com.sapi.activitystatesavetwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String TAG = "State: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Log.d(TAG, "onCreate() method was invoked without a previous state");
        } else {
            Log.d(TAG, "onCreate() method was invoked with a previous state");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText usernameEditText = (EditText)findViewById(R.id.editText);
        savedInstanceState.putString("myEditText", usernameEditText.getText().toString());
        CheckBox box = (CheckBox)findViewById(R.id.checkBox);
        savedInstanceState.putBoolean("mycheckbox", box.isChecked());
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText usernameEditText= (EditText)findViewById(R.id.editText);
        if (savedInstanceState.containsKey("myEditText")) {
            usernameEditText.setText(savedInstanceState.getString("myEditText"));
        }
        CheckBox box = (CheckBox)findViewById(R.id.checkBox);
        if (savedInstanceState.containsKey("mycheckbox")) {
            box.setChecked(savedInstanceState.getBoolean("mycheckbox"));
        }
        Log.d(TAG, "onRestoreInstanceState");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }

}
