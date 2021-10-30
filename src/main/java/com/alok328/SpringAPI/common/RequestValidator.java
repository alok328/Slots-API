package com.alok328.SpringAPI.common;

import com.alok328.SpringAPI.exception.SlotException;
import com.alok328.SpringAPI.model.request.SlotRequest;
import com.alok328.SpringAPI.util.DateTimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RequestValidator {
  public static void validateSlotRequestBody(SlotRequest slotRequest) {
    if(StringUtils.isAnyBlank(slotRequest.getBandName(), slotRequest.getDate(), slotRequest.getStartTime(), slotRequest.getEndTime())){
      throw new SlotException(HttpStatus.BAD_REQUEST, "Missing mandatory fields!");
    }
    DateTimeUtil.validateDateInput(slotRequest.getDate());
    DateTimeUtil.validateTimeInput(slotRequest.getStartTime());
    DateTimeUtil.validateTimeInput(slotRequest.getEndTime());
  }

  private static void validateTimeFormat(String time) {
    DateFormat timeFormat = new SimpleDateFormat("HH:mm");
    try {
      timeFormat.parse(time);
    } catch (ParseException e) {
      throw new SlotException(HttpStatus.BAD_REQUEST, "Invalid Time Format, required format: HH:mm");
    }
  }
}
