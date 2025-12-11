package com.example.photodiary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DiaryManager {
    private static final String PREFS_NAME = "diary_prefs";
    private static final String KEY_ENTRIES = "entries";
    private SharedPreferences prefs;
    private Gson gson;

    public DiaryManager(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public List<DiaryEntry> loadEntries() {
        String json = prefs.getString(KEY_ENTRIES, "[]");
        Type type = new TypeToken<ArrayList<DiaryEntry>>() {
        }.getType();
        List<DiaryEntry> entries = gson.fromJson(json, type);
        return entries != null ? entries : new ArrayList<>();
    }

    public void saveEntries(List<DiaryEntry> entries) {
        String json = gson.toJson(entries);
        prefs.edit().putString(KEY_ENTRIES, json).apply();
    }

    public void addEntry(DiaryEntry entry) {
        List<DiaryEntry> entries = loadEntries();
        entries.add(0, entry); // Legujabb elol
        saveEntries(entries);
    }
}

