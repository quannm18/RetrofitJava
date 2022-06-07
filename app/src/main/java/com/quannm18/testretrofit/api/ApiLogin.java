package com.quannm18.testretrofit.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quannm18.testretrofit.Login.LoginUser;
import com.quannm18.testretrofit.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiLogin {
    String url = "https://agile-server-beco.herokuapp.com/users/api-reg";
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiLogin apiLogin = new Retrofit.Builder()
            .baseUrl("https://agile-server-beco.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiLogin.class);
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("users/api-reg")
    Call<LoginUser> postRegister(@Field("hoTen") String hoTen,
                                 @Field("taiKhoan") String taiKhoan,
                                 @Field("matKhau") String matKhau,
                                 @Field("ngaySinh") String ngaySinh,
                                 @Field("queQuan") String queQuan,
                                 @Field("role") String role);

//https://agile-server-beco.herokuapp.com/users/api-edti-user/628ef6b251fd3cfc4d53440b
    @GET("users")
    Call<List<LoginUser>> getUserList();

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("users/api-edti-user/{id}")
    Call<Message> postUpdate(@Path(value = "id") String id,
                             @Field("hoTen") String hoTen,
                             @Field("taiKhoan") String taiKhoan,
                             @Field("matKhau") String matKhau,
                             @Field("ngaySinh") String ngaySinh,
                             @Field("queQuan") String queQuan,
                             @Field("role") String role);
}
