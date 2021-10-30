package com.alok328.SpringAPI.repository;

import com.alok328.SpringAPI.model.Slot;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface SlotRepository extends MongoRepository<Slot, String> {
    List<Slot> findByDate(LocalDate date);
}
