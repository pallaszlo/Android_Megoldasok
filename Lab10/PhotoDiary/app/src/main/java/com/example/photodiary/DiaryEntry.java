package com.example.photodiary;

public class DiaryEntry {
    private String id;
    private String title;
    private String content;
    private String photoPath;
    private long timestamp;

    public DiaryEntry(String title, String content) {
        this.title = title;
        this.content = content;
        this.id = String.valueOf(System.currentTimeMillis());
        this.timestamp = System.currentTimeMillis();
        this.photoPath = null;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getPhotoPath() { return photoPath; }
    public long getTimestamp() { return timestamp; }
    // Setters
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    // Hasznos metódusok
    public boolean hasPhoto() {
        return photoPath != null && !photoPath.isEmpty();
    }
    public String getFormattedDate() {
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy. MM. dd. HH:mm");
        return sdf.format(new java.util.Date(timestamp));
    }
}
