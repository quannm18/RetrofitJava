package com.quannm18.testretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.quannm18.testretrofit.api.ApiService;
import com.quannm18.testretrofit.model.Currency;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);


//        Job job = new Job(1,"Coder");
//        List<Favorite> favoriteList = new ArrayList<>();
//        favoriteList.add(new Favorite(1,"Music"));
//        favoriteList.add(new Favorite(2,"ReadBook"));
//
//        User user = new User(1, "Quan Ngo",true, job,favoriteList);
//
//        Gson gson = new Gson();
//        String strGson = gson.toJson(user);
//        Log.e("JSON",strGson);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallAPI();
            }

        });
    }
    private void clickCallAPI() {
        String url = "http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1";

        ApiService.apiService.convertUsdToVND(
                "843d4d34ae72b3882e3db642c51e28e6","VND","USD",1)
                .enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                Currency currency = response.body();
                if (currency!=null && currency.isSuccess()){
                    textView.setText(currency.toString());
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Log.e("Error",call.toString());
            }
        });
    }
}