package com.service.impl;

import com.model.Symptom;
import com.repository.SymptomRepository;
import com.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class SymptomServiceImpl implements SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    @Override
    public void save(Symptom symptom) {
        symptomRepository.save(symptom);
    }

    @Override
    public Symptom findById(Long id) {
        return symptomRepository.findById(id).get();
    }

    @Override
    public List<Symptom> findSymptomByPersonId(Long id_person) {
        return symptomRepository.findSymptomByPersonId(id_person);
    }

}
