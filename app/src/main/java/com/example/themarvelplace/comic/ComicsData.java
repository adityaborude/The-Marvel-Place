package com.example.themarvelplace.comic;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ComicsData {
    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private ArrayList<Comic> comics;

    public ComicsData(int count, ArrayList<Comic> comics) {
        this.count = count;
        this.comics = comics;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Comic> getComics() {
        return comics;
    }

    public void setComics(ArrayList<Comic> comics) {
        this.comics = comics;
    }
}
