package com.service;

import com.model.Symptom;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SymptomService {
    void save(Symptom symptom);

    Symptom findById(Long id);
    List<Symptom> findSymptomByPersonId(@Param("id") Long id_person);
}
