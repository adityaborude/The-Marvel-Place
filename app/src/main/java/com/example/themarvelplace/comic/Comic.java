package com.example.themarvelplace.comic;

import com.google.gson.annotations.SerializedName;

public class Comic {
    @SerializedName("title")
    private String title;

    @SerializedName("issueNumber")
    private int issueNumber;

    @SerializedName("thumbnail")
    private ComicThumbnail comicThumbnail;

    public Comic(String title, int issueNumber, ComicThumbnail comicThumbnail) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.comicThumbnail = comicThumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public ComicThumbnail getComicThumbnail() {
        return comicThumbnail;
    }

    public void setComicThumbnail(ComicThumbnail comicThumbnail) {
        this.comicThumbnail = comicThumbnail;
    }
}
