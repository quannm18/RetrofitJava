package com.quannm18.testretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Quotes {
    @SerializedName("USDVND")
    private int USDVND;

    public Quotes(int USDVND) {
        this.USDVND = USDVND;
    }

    public Quotes() {
    }

    public int getUSDVND() {
        return USDVND;
    }

    public void setUSDVND(int USDVND) {
        this.USDVND = USDVND;
    }
}
