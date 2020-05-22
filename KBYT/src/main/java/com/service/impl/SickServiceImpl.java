package com.service.impl;

import com.model.Sick;
import com.repository.SickRepository;
import com.service.SickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class SickServiceImpl implements SickService {

    @Autowired
    private SickRepository sickRepository;

    @Override
    public void save(Sick sick) {
        sickRepository.save(sick);
    }

    @Override
    public Sick findById(Long id) {
        return sickRepository.findById(id).get();
    }

    @Override
    public List<Sick> findSicksByPersonId(@Param("id") Long id_person) {
        return sickRepository.findSicksByPersonId(id_person);
    }


}
