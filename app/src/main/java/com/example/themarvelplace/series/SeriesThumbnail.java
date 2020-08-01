package com.example.themarvelplace.series;

import com.google.gson.annotations.SerializedName;

public class SeriesThumbnail {

    @SerializedName("path")
    private String path;

    @SerializedName("extension")
    private String extension;

    public SeriesThumbnail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getThumbnail() {
        return path + "." + extension;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
