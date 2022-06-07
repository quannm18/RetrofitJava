package com.quannm18.testretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.quannm18.testretrofit.Login.LoginUser;
import com.quannm18.testretrofit.api.ApiLogin;
import com.quannm18.testretrofit.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button button2;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button2 = (Button) findViewById(R.id.button2);
        textView2 = (TextView) findViewById(R.id.textView2);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiLogin.apiLogin.postRegister("NgoMinhQUan","quannm18","123","20/10/2002","QB","Admin")
                        .enqueue(new Callback<LoginUser>() {
                            @Override
                            public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {

                                LoginUser user = response.body();

                                if (user!=null){
                                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();

                                    Log.e("Success",response+"");
                                    textView2.setText(user.toString());
                                }else {
                                    Toast.makeText(LoginActivity.this, "Null", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<LoginUser> call, Throwable t) {
                                Log.e("Error",call.toString());

                            }
                        });
            }
        });
    }
}