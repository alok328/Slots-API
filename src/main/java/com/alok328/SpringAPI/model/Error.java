package com.alok328.SpringAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class Error {

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("type")
  private String type = "error";

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Error(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
