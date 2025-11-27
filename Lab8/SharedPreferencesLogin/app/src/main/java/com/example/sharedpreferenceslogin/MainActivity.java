package com.example.sharedpreferenceslogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         */
        SharedPreferences settings = getSharedPreferences("LoginPrefs", 0);
        if (settings.getBoolean("logged", false)) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }


        Button login = findViewById(R.id.loginbutton);
        EditText userName = findViewById(R.id.login);
        EditText password = findViewById(R.id.password);
        CheckBox rememberMe = findViewById(R.id.rememberMe);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("admin") && password.getText().toString().equals("password")) {
                    SharedPreferences settings = getSharedPreferences("LoginPrefs", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("username", userName.getText().toString());
                    if (rememberMe.isChecked()) {
                        editor.putBoolean("logged", true);
                    }
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Successfull login!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    //SharedPreferences settings = getSharedPreferences("LoginPrefs", 0);
                    int attempts = settings.getInt("failedAttempts", 0);
                    if (attempts > 3) {
                        login.setEnabled(false);
                    } else {
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putInt("failedAttempts", attempts + 1);
                    }
                }
            }
        });

    }
}