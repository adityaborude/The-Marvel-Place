package com.example.themarvelplace.character;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CharactersData {

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private ArrayList<Character> characters;

    public CharactersData(int count, ArrayList<Character> characters) {
        this.count = count;
        this.characters = characters;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }
}
