package ro.sapi.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tvSum;
    Button btnSendResult;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnSendResult = (Button) findViewById(R.id.btnSendResult);
        btnSendResult.setOnClickListener(this);

        // 1. get passed intent
        Intent intent = getIntent();

        // 2. get x & y from intent
        //ToDo

        // 3. get reference to tvSum
        //ToDo

        // 4. display x+y on textView
        //ToDo

    }

    @Override
    public void onClick(View view) {

        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",result);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}


