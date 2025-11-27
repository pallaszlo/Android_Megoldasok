package com.example.mytodoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ListView listView;
    private Button buttonNewTask;
    private List<Task> tasks;
    private TaskAdapter2 taskAdapter;
    private TaskManager taskManager;
    private Task selectedTask;

    private ActivityResultLauncher<Intent> addTaskLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listviewTasks);
        buttonNewTask = findViewById(R.id.buttonNewTask);
        taskManager = new TaskManager(this);

        addTaskLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String taskName = result.getData().getStringExtra("taskName");
                        String priority = result.getData().getStringExtra("priority");
                        Task newTask = new Task(taskName, priority);
                        taskManager.addTask(newTask);
                        loadTasks();
                        Toast.makeText(this, "Feladat hozzaadva", Toast.LENGTH_SHORT).show();
                    }
                });

        loadTasks();

        buttonNewTask.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity2.this, AddTaskActivity.class);
            addTaskLauncher.launch(intent);
        });

    }

    private void loadTasks() {
        tasks = taskManager.loadTasks();
        Task task1 = new Task("Sportolas", "Magas");
        tasks.add(task1);
        taskAdapter = new TaskAdapter2(this, tasks);
        listView.setAdapter(taskAdapter);

    }
}