package ro.sapi.staticfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Status:", "MainActivity:onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Status:", "MainActivity:onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Status:", "MainActivity:onDestroy");
    }
}
