package ro.sapi.sharedpreferenceslogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "LoginPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox rme  = findViewById(R.id.rememberMe);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getString("remember", "").toString().equals("true")) {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }

        Button b = (Button) findViewById(R.id.loginbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.login);
                EditText password = (EditText) findViewById(R.id.password);


                if(username.getText().toString().equals("alma") && password.getText().toString().equals("alma")) {
                    //make SharedPreferences object
                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = settings.edit();
                    //editor.putString("remember", "true");
                    if(rme.isChecked()){
                        editor.putString("remember", "true");
                    }
                    else{
                        editor.putString("remember", "false");
                    }
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                }

            }
        });
    }


}
