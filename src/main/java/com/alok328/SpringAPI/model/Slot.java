package com.alok328.SpringAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
public class Slot {
    @Id
    private String id;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String band;

    public Slot(LocalDate date, LocalDateTime startTime, LocalDateTime endTime, String band) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.band = band;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }
}
