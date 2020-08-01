package com.example.themarvelplace.event;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EventsData {

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private ArrayList<Event> events;

    public EventsData(int count, ArrayList<Event> events) {
        this.count = count;
        this.events = events;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
