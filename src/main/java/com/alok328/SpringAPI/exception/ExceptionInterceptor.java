package com.alok328.SpringAPI.exception;

import com.alok328.SpringAPI.model.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

  @ExceptionHandler(SlotException.class)
  public final ResponseEntity<Object> handleExceptions(SlotException ex){
    Error error = new Error(ex.getError().getMessage());
    return new ResponseEntity(error, ex.getStatus());
  }

}
