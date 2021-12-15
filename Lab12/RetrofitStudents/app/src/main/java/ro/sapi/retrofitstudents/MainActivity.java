package ro.sapi.retrofitstudents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView)findViewById(R.id.textView);
        final TextView program_id = (TextView)findViewById(R.id.program_id);
        final TextView name = (TextView)findViewById(R.id.name);
        final TextView email = (TextView)findViewById(R.id.email);
        final TextView status = (TextView)findViewById(R.id.status);
        final EditText editID   = (EditText)findViewById(R.id.editText);
        final EditText editName   = (EditText)findViewById(R.id.editName);
        final EditText editProgram   = (EditText)findViewById(R.id.editProgram);
        final EditText editEmail   = (EditText)findViewById(R.id.editEmail);

        final Button getButton = (Button)findViewById(R.id.buttonGet);
        final Button deleteButton = (Button) findViewById(R.id.buttonDelete);
        final Button addButton = (Button) findViewById(R.id.addStudent);


        final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);


        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Student> call = service.getStudentWithID(Integer.valueOf(editID.getText().toString()));
                call.enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {
                        Student stud = response.body();
                        program_id.setText(stud.getProgramId().toString());
                        name.setText(stud.getName());
                        email.setText(stud.getEmail());
                        status.setText(stud.getStatus().toString());
                        Log.d("info", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {
                        //tv.setText("Hiba!");
                        t.printStackTrace();

                    }
                });
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Student> call = service.deleteStudentWithID(Integer.valueOf(editID.getText().toString()));
                call.enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {
                        Student stud = response.body();

                        program_id.setText(stud.getProgramId().toString());
                        name.setText(stud.getName());
                        email.setText(stud.getEmail());
                        status.setText(stud.getStatus().toString());
                        Toast.makeText(MainActivity.this, "Sikeres törlés!", Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Hiba!", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();

                    }
                });
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Student> call = service.createStudent(Integer.valueOf(editProgram.getText().toString()), editName.getText().toString(),
                        editEmail.getText().toString(), 0);
                //Call<Student> call = service.updateStudent(5, editNev.getText().toString(),
                        //editSzak.getText().toString(), Integer.valueOf(editEvfolyam.getText().toString()));
                call.enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {
                        Student stud = response.body();
                        program_id.setText(stud.getProgramId().toString());
                        name.setText(stud.getName());
                        email.setText(stud.getEmail());
                        //status.setText(stud.getStatus().toString());
                        Toast.makeText(MainActivity.this, "Új hallgató létrehozva!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Hiba!", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();

                    }
                });
            }
        });
    }
}
