package ro.sapi.linearlayout2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button) findViewById(R.id.btn1);
        //bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("status:", "Okkkkkkkkkkkkkkkkkkkkkkkkk");
    }

    public void kattIde(View v) {
        Log.d("status:", "Okkkkkkkkkkkkkkkkkkkkkkkkk");
    }
}
