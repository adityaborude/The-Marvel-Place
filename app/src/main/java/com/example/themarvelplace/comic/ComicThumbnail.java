package com.example.themarvelplace.comic;

import com.google.gson.annotations.SerializedName;

public class ComicThumbnail {

    @SerializedName("path")
    private String path;

    @SerializedName("extension")
    private String extension;

    public ComicThumbnail(String path, String extension) {
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
