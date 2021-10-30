package com.alok328.SpringAPI.service;


import com.alok328.SpringAPI.model.Slot;
import com.alok328.SpringAPI.model.response.SlotResponse;

import java.util.List;
import java.util.Map;

public interface SlotService {

  SlotResponse addSlot(Slot slot);

  void clearData();

  List<SlotResponse> getSlots(Map<String, String> reqParams);
}
