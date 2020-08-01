package com.example.themarvelplace.event;

import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("thumbnail")
    private EventThumbnail eventThumbnail;

    public Event(String title, String description, EventThumbnail eventThumbnail) {
        this.title = title;
        this.description = description;
        this.eventThumbnail = eventThumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventThumbnail getEventThumbnail() {
        return eventThumbnail;
    }

    public void setEventThumbnail(EventThumbnail eventThumbnail) {
        this.eventThumbnail = eventThumbnail;
    }
}
