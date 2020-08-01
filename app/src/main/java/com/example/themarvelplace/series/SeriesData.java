package com.example.themarvelplace.series;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SeriesData {

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private ArrayList<Series> series;

    public SeriesData(int count, ArrayList<Series> series) {
        this.count = count;
        this.series = series;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Series> getSeries() {
        return series;
    }

    public void setSeries(ArrayList<Series> series) {
        this.series = series;
    }
}
