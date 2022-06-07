package com.quannm18.testretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.quannm18.testretrofit.Login.LoginUser;
import com.quannm18.testretrofit.adapter.UserAdapter;
import com.quannm18.testretrofit.api.ApiLogin;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RCVActivity extends AppCompatActivity {
    private RecyclerView rcvListUser;
    private List<LoginUser> userList;
    private UserAdapter adapter;
    public static boolean isSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcvactivity);
        isSuccess=false;
        rcvListUser = (RecyclerView) findViewById(R.id.rcvListUser);
        userList = new ArrayList<>();
        userList = getListUser();
        adapter = new UserAdapter(userList);

        rcvListUser.setLayoutManager(new LinearLayoutManager(RCVActivity.this));
        rcvListUser.setAdapter(adapter);

    }

    public List<LoginUser> getListUser() {
        List<LoginUser> listUser = new ArrayList<>();

        ApiLogin.apiLogin.getUserList().enqueue(new Callback<List<LoginUser>>() {
            @Override
            public void onResponse(Call<List<LoginUser>> call, Response<List<LoginUser>> response) {
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                List<LoginUser> userList = response.body();
                for (LoginUser user:
                     userList) {
                    listUser.add(user);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<LoginUser>> call, Throwable t) {
                Log.e("error",call+"");

            }
        });
        return listUser;
    }
}