package com.alok328.SpringAPI.service;

import com.alok328.SpringAPI.dao.SlotDao;
import com.alok328.SpringAPI.model.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SlotService {

    private final SlotDao slotDao;

    @Autowired
    public SlotService(SlotDao slotDao) {
        this.slotDao = slotDao;
    }

    public boolean addSlot(Slot slot){
        LocalDateTime s1 = slot.getStartTime();
        LocalDateTime e1 = slot.getEndTime();
        if(s1.isAfter(e1)){
            return false;
        }
        List<Slot> db = slotDao.findByDate(slot.getDate());
        for(Slot x : db){
            LocalDateTime s2 = x.getStartTime();
            LocalDateTime e2 = x.getEndTime();
            if(x.getBand().equals(slot.getBand())){
                return false;
            }
            if(s1.isBefore(e2) && s2.isBefore(e1)){
                return false;
            }
        }
        slotDao.insert(slot);
        return true;
    }

    public List<Slot> getAllSlots(){
        return slotDao.findAll();
    }
}
