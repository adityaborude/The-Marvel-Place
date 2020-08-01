package com.example.themarvelplace.series;

import com.google.gson.annotations.SerializedName;

public class SeriesList {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private SeriesData seriesData;

    public SeriesList(String status, SeriesData seriesData) {
        this.status = status;
        this.seriesData = seriesData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SeriesData getSeriesData() {
        return seriesData;
    }

    public void setSeriesData(SeriesData seriesData) {
        this.seriesData = seriesData;
    }
}
