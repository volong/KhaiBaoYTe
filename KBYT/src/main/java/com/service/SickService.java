package com.service;

import com.model.Sick;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SickService {
    void save(Sick sick);
    Sick findById(Long id);

    List<Sick> findSicksByPersonId(@Param("id") Long id_person);
}
