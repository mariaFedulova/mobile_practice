package com.example.recyclerviewapp;

public class HistoricalEvent {
    private String eventName;
    private String img;
    private String eventDescription;
    public HistoricalEvent(String eventName, String img, String eventDescription) {
        this.eventName= eventName;
        this.img= img;
        this.eventDescription= eventDescription;
    }
    public String getEventDescription() {
        return eventDescription;
    }
    public String getEventName() {
        return eventName;
    }
    public String getImg() {
        return img;
    }
    @Override
    public String toString() {
        return this.eventName+" (Description: "+ this.eventDescription+")";
    }
}
