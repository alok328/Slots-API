package com.alok328.SpringAPI.common;

import com.alok328.SpringAPI.exception.SlotException;
import com.alok328.SpringAPI.model.request.SlotRequest;
import com.alok328.SpringAPI.util.DateTimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RequestValidator {
  public static void validateSlotRequestBody(SlotRequest slotRequest) {
    if(StringUtils.isAnyBlank(slotRequest.getBandName(), slotRequest.getDate(), slotRequest.getStartTime(), slotRequest.getEndTime())){
      throw new SlotException(HttpStatus.BAD_REQUEST, "Missing mandatory fields!");
    }
    DateTimeUtil.validateDateInput(slotRequest.getDate());
    DateTimeUtil.validateTimeInput(slotRequest.getStartTime());
    DateTimeUtil.validateTimeInput(slotRequest.getEndTime());
  }

  public static void validateRequestParamsForGetSlots(Map<String, String> reqParams) {
    if(reqParams.size()==0){
      return;
    }
    if(reqParams.size()==1 && reqParams.containsKey(Constants.QUERY_PARAM_BAND_NAME)){
      throw new SlotException(HttpStatus.BAD_REQUEST, "Search of slots for band requires date parameter as well.");
    }
    if(reqParams.containsKey(Constants.QUERY_PARAM_DATE)){
      DateTimeUtil.validateDateInput(reqParams.get(Constants.QUERY_PARAM_DATE));
    }
    reqParams.keySet().forEach(rp -> {
      if(!rp.equals(Constants.QUERY_PARAM_BAND_NAME) && !rp.equals(Constants.QUERY_PARAM_DATE)){
        throw new SlotException(HttpStatus.BAD_REQUEST, "Invalid Query Param in request, valid params: [bandName, date]");
      }
    });
  }
}
