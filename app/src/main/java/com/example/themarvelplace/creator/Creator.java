package com.example.themarvelplace.creator;

import com.google.gson.annotations.SerializedName;

public class Creator {

    @SerializedName("fullName")
    private String fullName;

    @SerializedName("thumbnail")
    private CreatorThumbnail creatorThumbnail;

    public Creator(String fullName, CreatorThumbnail creatorThumbnail) {
        this.fullName = fullName;
        this.creatorThumbnail = creatorThumbnail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public CreatorThumbnail getCreatorThumbnail() {
        return creatorThumbnail;
    }

    public void setCreatorThumbnail(CreatorThumbnail creatorThumbnail) {
        this.creatorThumbnail = creatorThumbnail;
    }
}
