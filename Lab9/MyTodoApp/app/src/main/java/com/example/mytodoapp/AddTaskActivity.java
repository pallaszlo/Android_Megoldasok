package com.example.mytodoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddTaskActivity extends AppCompatActivity {
    private EditText editTextTaskName;
    private RadioGroup radioGroupPriority;
    private Button buttonOk, buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTextTaskName = findViewById(R.id.editTextTaskName);
        radioGroupPriority = findViewById(R.id.radioGroupPriority);
        buttonOk = findViewById(R.id.buttonOk);
        buttonCancel = findViewById(R.id.buttonCancel);

        buttonOk.setOnClickListener(v -> {
            String taskName = editTextTaskName.getText().toString().trim();

            if (taskName.isEmpty()) {
                Toast.makeText(AddTaskActivity.this, "Kérlek add meg a feladat nevét", Toast.LENGTH_SHORT).show();
                return;
            }

            int selectedId = radioGroupPriority.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(AddTaskActivity.this, "Kérlek válassz prioritást", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedRadio = findViewById(selectedId);
            String priority = selectedRadio.getText().toString();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("taskName", taskName);
            resultIntent.putExtra("priority", priority);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        buttonCancel.setOnClickListener(v -> finish());
    }
}
