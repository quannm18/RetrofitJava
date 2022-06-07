package com.quannm18.testretrofit;

public class Favorite {
    private int id;
    private String favorites;

    public Favorite(int id, String favorites) {
        this.id = id;
        this.favorites = favorites;
    }

    public Favorite() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }
}
