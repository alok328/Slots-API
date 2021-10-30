package com.alok328.SpringAPI.model.mapper;

import com.alok328.SpringAPI.common.Constants;
import com.alok328.SpringAPI.model.Slot;
import com.alok328.SpringAPI.model.request.SlotRequest;
import com.alok328.SpringAPI.model.response.SlotResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ModelMapper {

  public static Slot mapSlotRequestToSlot (SlotRequest slotRequest){
    Slot slot = new Slot();
    slot.setDate(parseDateFromString(slotRequest.getDate()));
    slot.setStartDateTime(createDateTimeFromRequest(slotRequest.getDate(), slotRequest.getStartTime()));
    slot.setEndDateTime(createDateTimeFromRequest(slotRequest.getDate(), slotRequest.getEndTime()));
    slot.setBandName(slotRequest.getBandName());
    return slot;
  }

  private static LocalDateTime createDateTimeFromRequest(String date, String startTime) {
    LocalDate parsedDate = parseDateFromString(date);
    LocalTime parsedTime = parseTimeFromString(startTime);
    return LocalDateTime.of(parsedDate, parsedTime);
  }

  private static LocalTime parseTimeFromString(String time) {
    return LocalTime.parse(time, DateTimeFormatter.ofPattern(Constants.TIME_FORMAT));
  }

  private static LocalDate parseDateFromString(String date) {
    return LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
  }

  public static SlotResponse mapSlotToSlotResponse(Slot slot) {
    SlotResponse response = new SlotResponse();
    response.setBandName(slot.getBandName());
    response.setStartDateTime(slot.getStartDateTime().toString());
    response.setEndDateTime(slot.getEndDateTime().toString());
    return response;
  }

  public static List<SlotResponse> mapAllSlotsToSlotResponses(List<Slot> slots) {
    return slots.stream().map(ModelMapper::mapSlotToSlotResponse).sorted(Comparator.comparing(SlotResponse::getStartDateTime)).collect(Collectors.toList());
  }
}
