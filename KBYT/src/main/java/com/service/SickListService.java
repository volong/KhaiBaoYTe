package com.service;

import com.model.ListSick;

import java.util.List;

public interface SickListService {
    List<ListSick> findAll();

    ListSick findById(Long id);
}
