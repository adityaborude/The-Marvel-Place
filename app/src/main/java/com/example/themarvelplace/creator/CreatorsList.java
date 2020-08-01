package com.example.themarvelplace.creator;

import com.google.gson.annotations.SerializedName;

public class CreatorsList {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private CreatorsData creatorsData;

    public CreatorsList(String status, CreatorsData creatorsData) {
        this.status = status;
        this.creatorsData = creatorsData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CreatorsData getCreatorsData() {
        return creatorsData;
    }

    public void setCreatorsData(CreatorsData creatorsData) {
        this.creatorsData = creatorsData;
    }
}
