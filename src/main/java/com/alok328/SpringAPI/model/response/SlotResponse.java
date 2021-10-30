package com.alok328.SpringAPI.model.response;

public class SlotResponse {

  private String bandName;
  private String startDateTime;
  private String endDateTime;

  public SlotResponse() {
  }

  public SlotResponse(String bandName, String startDateTime, String endDateTime) {
    this.bandName = bandName;
    this.startDateTime = startDateTime;
    this.endDateTime = endDateTime;
  }

  public String getBandName() {
    return bandName;
  }

  public void setBandName(String bandName) {
    this.bandName = bandName;
  }

  public String getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(String startDateTime) {
    this.startDateTime = startDateTime;
  }

  public String getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(String endDateTime) {
    this.endDateTime = endDateTime;
  }
}
