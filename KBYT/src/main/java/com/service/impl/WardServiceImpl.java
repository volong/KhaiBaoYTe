package com.service.impl;

import com.model.Ward;
import com.repository.WardRepository;
import com.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WardServiceImpl implements WardService {

    @Autowired
    private WardRepository wardRepository;

    @Override
    public List<Ward> findAll() {
        return wardRepository.findAll();
    }


}
