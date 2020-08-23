package com.alok328.SpringAPI.api;

import com.alok328.SpringAPI.model.Request.SlotRequestBody;
import com.alok328.SpringAPI.model.Slot;
import com.alok328.SpringAPI.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/slot")
@RestController
public class SlotController {

    private final SlotService slotService;

    @Autowired
    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping
    public boolean addSlot(@RequestBody SlotRequestBody slotRequestBody){
        Slot slot = new Slot(LocalDate.of(slotRequestBody.getYear(), slotRequestBody.getMonth(), slotRequestBody.getDate()),
            LocalDateTime.of(slotRequestBody.getYear(), slotRequestBody.getMonth(), slotRequestBody.getDate(), slotRequestBody.getStartHour(), slotRequestBody.getStartMin()),
            LocalDateTime.of(slotRequestBody.getYear(), slotRequestBody.getMonth(), slotRequestBody.getDate(), slotRequestBody.getEndHour(), slotRequestBody.getEndMin()),
            slotRequestBody.getBand());
        return slotService.addSlot(slot);
    }

    @GetMapping
    public List<Slot> getAllSlots(){
        return slotService.getAllSlots();
    }
}
