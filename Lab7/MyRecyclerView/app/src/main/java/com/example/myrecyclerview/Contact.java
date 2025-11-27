package com.example.myrecyclerview;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String name;
    private int thumbnail;
    private String number;

    public Contact(String name, int thumbnail, String number) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Adam", R.drawable.contact_one, "07564325668"));
        contacts.add(new Contact("Adam", R.drawable.contact_two, "07564325668"));
        contacts.add(new Contact("Adam", R.drawable.contact_three, "07564325668"));
        contacts.add(new Contact("Adam", R.drawable.contact_four, "07564325668"));
        contacts.add(new Contact("Adam", R.drawable.contact_five, "07564325668"));
        contacts.add(new Contact("Adam", R.drawable.contact_six, "07564325668"));
        contacts.add(new Contact("Adam", R.drawable.contact_seven, "07564325668"));
        return contacts;

    }
}
