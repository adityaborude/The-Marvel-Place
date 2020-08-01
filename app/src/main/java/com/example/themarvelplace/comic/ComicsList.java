package com.example.themarvelplace.comic;

import com.google.gson.annotations.SerializedName;

public class ComicsList {
    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private ComicsData comicsData;

    public ComicsList(String status, ComicsData comicsData) {
        this.status = status;
        this.comicsData = comicsData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ComicsData getComicsData() {
        return comicsData;
    }

    public void setComicsData(ComicsData comicsData) {
        this.comicsData = comicsData;
    }
}
