package com.alok328.SpringAPI.exception;

import com.alok328.SpringAPI.model.Error;
import org.springframework.http.HttpStatus;

public class SlotException extends RuntimeException{

  private final transient Error error;
  private final transient HttpStatus status;

  public SlotException(HttpStatus status, String message) {
    this.error = new Error(message);
    this.status = status;
  }

  public Error getError() {
    return error;
  }

  public HttpStatus getStatus() {
    return status;
  }
}
