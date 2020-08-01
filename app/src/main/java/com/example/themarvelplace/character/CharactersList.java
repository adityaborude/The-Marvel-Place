package com.example.themarvelplace.character;

import com.google.gson.annotations.SerializedName;

public class CharactersList {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private CharactersData charactersData;

    public CharactersList(String status, CharactersData charactersData) {
        this.status = status;
        this.charactersData = charactersData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CharactersData getCharactersData() {
        return charactersData;
    }

    public void setCharactersData(CharactersData charactersData) {
        this.charactersData = charactersData;
    }
}
