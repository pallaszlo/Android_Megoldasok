package com.example.mytodoapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static final String PREFS_NAME = "TaskListPrefs";
    private static final String TASKS_KEY = "tasks";
    private SharedPreferences prefs;
    private Gson gson;

    public TaskManager(Context context){
        this.prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        this.gson = new Gson();
    }

    // Feladatok mentése
    public void saveTasks(List<Task> tasks) {
        String json = gson.toJson(tasks);
        prefs.edit().putString(TASKS_KEY, json).apply();
    }

    // Feladatok betöltése
    public List<Task> loadTasks() {
        String json = prefs.getString(TASKS_KEY, "[]");
        Type type = new TypeToken<ArrayList<Task>>(){}.getType();
        return gson.fromJson(json, type);
    }
    // Feladat hozzáadása
    public void addTask(Task task) {
        List<Task> tasks = loadTasks();
        tasks.add(task);
        saveTasks(tasks);
    }

    // Feladat törlése ID alapján
    public void deleteTask(long id) {
        List<Task> tasks = loadTasks();
        tasks.removeIf(task -> task.getId() == id);
        saveTasks(tasks);
    }

    // Feladat frissítése
    public void updateTask(Task updatedTask) {
        List<Task> tasks = loadTasks();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == updatedTask.getId()) {
                tasks.set(i, updatedTask);
                break;
            }
        }
        saveTasks(tasks);
    }


}
