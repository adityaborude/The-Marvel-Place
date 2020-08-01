package com.example.themarvelplace.series;

import com.google.gson.annotations.SerializedName;

public class Series {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String desc;

    @SerializedName("thumbnail")
    private SeriesThumbnail seriesThumbnail;

    public Series(String title, String desc, SeriesThumbnail seriesThumbnail) {
        this.title = title;
        this.desc = desc;
        this.seriesThumbnail = seriesThumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public SeriesThumbnail getSeriesThumbnail() {
        return seriesThumbnail;
    }

    public void setSeriesThumbnail(SeriesThumbnail seriesThumbnail) {
        this.seriesThumbnail = seriesThumbnail;
    }
}
