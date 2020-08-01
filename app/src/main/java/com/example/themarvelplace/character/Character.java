package com.example.themarvelplace.character;

import com.google.gson.annotations.SerializedName;

public class Character {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("thumbnail")
    private CharacterThumbnail characterThumbnail;

    public Character(String name, String description, CharacterThumbnail thumbnail) {
        this.name = name;
        this.description = description;
        this.characterThumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CharacterThumbnail getCharacterThumbnail() {
        return characterThumbnail;
    }

    public void setThumbnail(CharacterThumbnail characterThumbnail) {
        this.characterThumbnail = characterThumbnail;
    }
}
