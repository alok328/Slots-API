package com.alok328.SpringAPI.model;

import com.alok328.SpringAPI.util.SlotUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Document("slots")
public class Slot {
    @Id
    private String id;
    private LocalDate date;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String bandName;

    public Slot() {
        this.id = SlotUtil.generateUniqueId();
    }

    public Slot(LocalDate date, LocalDateTime startDateTime, LocalDateTime endDateTime, String bandName) {
        this();
        this.date = date;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.bandName = bandName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
}
