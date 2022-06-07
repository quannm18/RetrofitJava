package com.quannm18.testretrofit.Login;

import com.google.gson.annotations.SerializedName;

public class Tokens {
    @SerializedName("token")
    private String token;

    public Tokens(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
