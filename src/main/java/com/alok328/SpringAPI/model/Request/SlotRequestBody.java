package com.alok328.SpringAPI.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlotRequestBody {

    private int date;
    private int month;
    private int year;
    private int startHour;
    private int startMin;
    private int endHour;
    private int endMin;
    private String band;

    public SlotRequestBody(@JsonProperty("date") int date,
                           @JsonProperty("month") int month, @JsonProperty("year") int year,
                           @JsonProperty("startHour") int startHour, @JsonProperty("startMin") int startMin,
                           @JsonProperty("endHour") int endHour, @JsonProperty("endMin") int endMin,
                           @JsonProperty("band") String band) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.startHour = startHour;
        this.startMin = startMin;
        this.endHour = endHour;
        this.endMin = endMin;
        this.band = band;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMin() {
        return startMin;
    }

    public void setStartMin(int startMin) {
        this.startMin = startMin;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMin() {
        return endMin;
    }

    public void setEndMin(int endMin) {
        this.endMin = endMin;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }
}
