package ro.sapi.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnGetResult;
    EditText etX, etY;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetResult = (Button) findViewById(R.id.btnGetResult);
        etX = (EditText) findViewById(R.id.etX);
        etY = (EditText) findViewById(R.id.etY);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnGetResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // 1. create an intent pass class name or intnet action name
        //ToDo

        // 2. put X, Y in intent
        //ToDo

        // 3. start the activity
        //ToDo
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            //ToDo
        }

    }
}
