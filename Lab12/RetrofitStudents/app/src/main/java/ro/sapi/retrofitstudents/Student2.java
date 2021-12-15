package ro.sapi.retrofitstudents;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student2 {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;

    public Student2() {
    }

    public Student2(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
