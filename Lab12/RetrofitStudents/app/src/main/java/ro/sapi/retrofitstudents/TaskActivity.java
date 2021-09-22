package ro.sapi.retrofitstudents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        EditText descr = findViewById(R.id.editDescription);
        Button sendTask = findViewById(R.id.addDescription);
        final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);
        sendTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}