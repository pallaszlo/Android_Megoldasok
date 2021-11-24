package com.example.okhttplist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static String USERS_URL = "https://reqres.in/api/users";
    private RecyclerView recyclerView;
    private List<User> userList = new ArrayList<>();
    private String userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initId();
        getData();
    }

    private void initId() {
        recyclerView = findViewById(R.id.rvUsers);
    }

    private void getData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(USERS_URL).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                userData = response.body().string();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(userData);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObj = jsonArray.getJSONObject(i);
                        User newUser = new User(jsonObj.getInt("id"), jsonObj.getString("first_name"), jsonObj.getString("last_name"),
                                jsonObj.getString("email"), jsonObj.getString("avatar"));
                        userList.add(newUser);
                    }
                    //Log.d("TAG", userData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        UserAdapter courseAdapter = new UserAdapter(MainActivity.this, userList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(courseAdapter);
                    }
                });
            }
        });
    }
}