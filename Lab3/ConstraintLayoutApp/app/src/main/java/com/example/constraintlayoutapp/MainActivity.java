package com.example.constraintlayoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText email = findViewById(R.id.edtEmail);
        EditText password = findViewById(R.id.edtPassword);
        Button signIn = findViewById(R.id.btnSignIn);

        String correctEmail = getString(R.string.email);
        String correctPassword = getString(R.string.password);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals(correctEmail) &&
                        password.getText().toString().equals(correctPassword)) {
                    Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                    myIntent.putExtra("email", correctEmail);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Hibas email vagy jelszo!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}