package com.alok328.SpringAPI.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlotRequest {

    @JsonProperty("date")
    private String date;

    @JsonProperty("startTime")
    private String startTime;

    @JsonProperty("endTime")
    private String endTime;

    @JsonProperty("bandName")
    private String bandName;


    public SlotRequest(String date, String startTime, String endTime, String bandName) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bandName = bandName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
}
