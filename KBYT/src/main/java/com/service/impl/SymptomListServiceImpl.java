package com.service.impl;

import com.model.Interface.ISaticalSymptom;
import com.model.ListSymptom;
import com.repository.SymptomListRepository;
import com.service.SymptomListService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

public class SymptomListServiceImpl implements SymptomListService {

    @Autowired
    private SymptomListRepository symptomListRepository;

    @Override
    public Iterable<ListSymptom> findAll() {
        return symptomListRepository.findAll();
    }

    @Override
    public ListSymptom findById(Long id) {
        return symptomListRepository.findById(id).get();
    }

    @Override
    public List<ISaticalSymptom> countListSymptom(Date startDate, Date endDate) {
        return symptomListRepository.countListSymptom(startDate, endDate);
    }


}
