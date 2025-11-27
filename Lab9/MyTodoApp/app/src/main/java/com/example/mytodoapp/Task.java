package com.example.mytodoapp;

public class Task {
    private String name;
    private String priority; // "Alacsony", "Közepes", "Magas"
    private boolean completed;
    private long id;

    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
        this.completed = false;
        this.id = System.currentTimeMillis();
    }

    public Task(String name, String priority, boolean completed, long id) {
        this.name = name;
        this.priority = priority;
        this.completed = completed;
        this.id = id;
    }

    // Getters és Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
