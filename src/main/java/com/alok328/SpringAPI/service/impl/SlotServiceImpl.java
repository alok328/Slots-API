package com.alok328.SpringAPI.service.impl;

import com.alok328.SpringAPI.exception.SlotException;
import com.alok328.SpringAPI.model.Slot;
import com.alok328.SpringAPI.model.mapper.ModelMapper;
import com.alok328.SpringAPI.model.response.SlotResponse;
import com.alok328.SpringAPI.repository.SlotRepository;
import com.alok328.SpringAPI.service.SlotService;
import com.alok328.SpringAPI.service.helper.Interval;
import com.alok328.SpringAPI.service.helper.IntervalHelper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SlotServiceImpl implements SlotService {

  private final SlotRepository slotRepository;

  public SlotServiceImpl(SlotRepository slotRepository) {
    this.slotRepository = slotRepository;
  }

  @Override
  public SlotResponse addSlot(Slot slot) {
    validateSlotStartTimeBeforeEndTime(slot);
    validateNoOverlap(slot);
    try {
      Slot saved = slotRepository.save(slot);
      return ModelMapper.mapSlotToSlotResponse(saved);
    } catch (Exception e) {
      e.printStackTrace();
      throw new SlotException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while adding slot: " + e);
    }
  }

  @Override
  public void clearData() {
    slotRepository.deleteAll();
  }

  @Override
  public List<SlotResponse> getSlots() {
    return ModelMapper.mapAllSlotsToSlotResponses(slotRepository.findAll());
  }

  private void validateNoOverlap(Slot slot) {
    List<Slot> slots = slotRepository.findByDate(slot.getDate());
    if (slots.stream().anyMatch(s -> (slot.getStartDateTime().isEqual(s.getStartDateTime()) && slot.getEndDateTime().isEqual(s.getEndDateTime())))) {
      throw new SlotException(HttpStatus.CONFLICT, "Slot already occupied between: " + slot.getStartDateTime() + " & " + slot.getEndDateTime());
    }

    List<Interval> intervals = slots.stream().map(s -> new Interval(s.getStartDateTime(), s.getEndDateTime())).collect(Collectors.toList());
    List<Interval> mergedIntervals = IntervalHelper.mergeIntervals(intervals);

    List<Interval> overlappingIntervals = mergedIntervals.stream()
        .filter(i ->
            (
                i.getStartDateTime().isEqual(slot.getStartDateTime()) ||
                i.getEndDateTime().isEqual(slot.getEndDateTime()) ||
                (i.getStartDateTime().isAfter(slot.getStartDateTime()) && i.getStartDateTime().isBefore(slot.getEndDateTime())) ||
                (i.getEndDateTime().isAfter(slot.getStartDateTime()) && i.getEndDateTime().isBefore(slot.getEndDateTime())) ||
                (slot.getStartDateTime().isAfter(i.getStartDateTime()) && slot.getEndDateTime().isBefore(i.getEndDateTime()))
            )
        ).collect(Collectors.toList());

//    List<Slot> overlappingSlots = slots.stream()
//        .filter
//            (s ->
//                (slot.getStartDateTime().isAfter(s.getStartDateTime()) && slot.getStartDateTime().isBefore(s.getEndDateTime())
//                    || (slot.getEndDateTime().isAfter(s.getStartDateTime()) && slot.getEndDateTime().isBefore(s.getEndDateTime()))
//                    || (slot.getStartDateTime().isBefore(s.getStartDateTime()) && slot.getEndDateTime().isAfter(s.getEndDateTime()))
//                )
//            ).collect(Collectors.toList());
    if (overlappingIntervals.size() > 0) {
      List<String> occupiedSlots = overlappingIntervals.stream().map(i -> i.getStartDateTime().toString() + " " + i.getEndDateTime().toString()).collect(Collectors.toList());
      throw new SlotException(HttpStatus.CONFLICT, "Slots occupied for requested range: " + occupiedSlots);
    }
  }

  private void validateSlotStartTimeBeforeEndTime(Slot slot) {
    if (slot.getStartDateTime().isAfter(slot.getEndDateTime())) {
      throw new SlotException(HttpStatus.BAD_REQUEST, "Start time must be before endTime");
    }
  }

}
