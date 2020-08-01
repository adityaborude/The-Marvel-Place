package com.example.themarvelplace.creator;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CreatorsData {

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private ArrayList<Creator> creators;

    public CreatorsData(int count, ArrayList<Creator> creators) {
        this.count = count;
        this.creators = creators;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Creator> getCreators() {
        return creators;
    }

    public void setCreators(ArrayList<Creator> creators) {
        this.creators = creators;
    }
}
