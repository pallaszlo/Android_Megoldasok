package ro.sapi.retrofitstudents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        final EditText descr = findViewById(R.id.editDescription);
        Button sendTask = findViewById(R.id.addDescription);
        final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);
        sendTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Task> call = service.saveTask(new Task(descr.getText().toString()));
                call.enqueue(new Callback<Task>() {
                    @Override
                    public void onResponse(Call<Task> call, Response<Task> response) {
                        Task task = response.body();
                        Toast.makeText(getApplicationContext(), "Új teendo létrehozva!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Task> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Hiba!", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
            }
        });

    }
}