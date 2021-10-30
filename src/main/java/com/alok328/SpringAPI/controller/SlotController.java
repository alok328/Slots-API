package com.alok328.SpringAPI.controller;

import com.alok328.SpringAPI.common.RequestValidator;
import com.alok328.SpringAPI.model.mapper.ModelMapper;
import com.alok328.SpringAPI.model.request.SlotRequest;
import com.alok328.SpringAPI.model.response.SlotResponse;
import com.alok328.SpringAPI.service.SlotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/slot")
@RestController
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping
    public SlotResponse addSlot(@RequestBody SlotRequest slotRequest){
        RequestValidator.validateSlotRequestBody(slotRequest);
        return slotService.addSlot(ModelMapper.mapSlotRequestToSlot(slotRequest));
    }

    @GetMapping
    public List<SlotResponse> getSlots(@RequestParam(required = false) Map<String, String> reqParams){
        RequestValidator.validateRequestParamsForGetSlots(reqParams);
        return slotService.getSlots(reqParams);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void clearData(){
        slotService.clearData();
    }

}
