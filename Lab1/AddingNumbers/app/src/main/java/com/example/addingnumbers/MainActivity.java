package com.example.addingnumbers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

        EditText text1 = findViewById(R.id.edtText1);
        EditText text2 = findViewById(R.id.edtText2);
        TextView tv = findViewById(R.id.txtEredmeny);
        Button szamol  = findViewById(R.id.btnSzamol);

        szamol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double eredmeny = Double.parseDouble(text1.getText().toString()) +
                            Double.parseDouble(text2.getText().toString());
                    tv.setText(Double.toString(eredmeny));
                    Toast.makeText(MainActivity.this, text2.getText().toString(), Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Konverzios hiba!", Toast.LENGTH_SHORT).show();;
                }
            }
        });
    }
}