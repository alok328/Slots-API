package com.alok328.SpringAPI.util;

import com.alok328.SpringAPI.common.Constants;
import com.alok328.SpringAPI.exception.SlotException;
import org.apache.commons.validator.GenericValidator;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeUtil {

  public static void validateDateInput(String date) {
    try{
      DateTimeUtil.parseDateFromPattern(date);
    } catch (IllegalArgumentException e){
      throw new SlotException(HttpStatus.BAD_REQUEST, "Invalid Date Value");
    }
  }

  public static void validateTimeInput(String time) {
    try{
      DateTimeUtil.parseTimeFromPattern(time);
    } catch (IllegalArgumentException e){
      throw new SlotException(HttpStatus.BAD_REQUEST, "Invalid Time format");
    }
  }

  public static void parseTimeFromPattern(String time) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.TIME_FORMAT);
    try{
      LocalTime.parse(time, formatter);
    }catch (DateTimeParseException e){
      throw new IllegalArgumentException("Invalid Time Value");
    }
  }

  public static void parseDateFromPattern(String date) {
    String pattern = Constants.DATE_FORMAT;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    if(GenericValidator.isDate(date, pattern, true)){
      formatter.parse(date);
    }else{
      throw new IllegalArgumentException("Invalid Date Value");
    }
  }

  public static LocalDate parseDateFromString(String date) {
    return LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
  }
}
