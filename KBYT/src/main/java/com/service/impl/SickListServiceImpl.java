package com.service.impl;

import com.model.ListSick;
import com.repository.SickListRepository;
import com.service.SickListService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SickListServiceImpl implements SickListService {

    @Autowired
    private SickListRepository sickListRepository;

    @Override
    public List<ListSick> findAll() {
        return sickListRepository.findAll();
    }

    @Override
    public ListSick findById(Long id) {
        return sickListRepository.findById(id).get();
    }
}
