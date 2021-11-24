package ro.sapi.constraintlayput1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText password;
    EditText email;
    Button gomb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        gomb = findViewById(R.id.button1);

        gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("admin@admin.ro")){
                    Intent i = new Intent(getApplicationContext(), ActivityTwo.class);
                    i.putExtra("email", email.getText().toString());
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Hibas jelszo vagy email!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
