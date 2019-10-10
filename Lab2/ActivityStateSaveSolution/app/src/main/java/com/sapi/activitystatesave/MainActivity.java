package com.sapi.activitystatesave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String TAG = "State: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView) findViewById(R.id.textview);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.append("\n" + tv.getText());
            }
        });

        if (savedInstanceState == null) {
            Log.d(TAG, "onCreate() method was invoked without a previous state");
        } else {
            TextView usernameEditText= (TextView)findViewById(R.id.textview);
            if (savedInstanceState.getString("myEditText") != null) {
                usernameEditText.setText(savedInstanceState.getString("myEditText"));
            }
            Log.d(TAG, "onCreate() method was invoked with a previous state");
        }

    }
        @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        TextView usernameEditText = (TextView)findViewById(R.id.textview);
        savedInstanceState.putString("myEditText", usernameEditText.getText().toString());
        Log.d(TAG, "onSaveInstanceState");
    }

   // @Override
/*    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView usernameEditText= (TextView)findViewById(R.id.textview);
        if (savedInstanceState.getString("myEditText") != null) {
            usernameEditText.setText(savedInstanceState.getString("myEditText"));
        }
        Log.d(TAG, "onRestoreInstanceState");
    }*/

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
