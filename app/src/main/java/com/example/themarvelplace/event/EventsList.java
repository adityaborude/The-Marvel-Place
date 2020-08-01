package com.example.themarvelplace.event;

import com.google.gson.annotations.SerializedName;

public class EventsList {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private EventsData eventsData;

    public EventsList(String status, EventsData eventsData) {
        this.status = status;
        this.eventsData = eventsData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EventsData getEventsData() {
        return eventsData;
    }

    public void setEventsData(EventsData eventsData) {
        this.eventsData = eventsData;
    }
}
