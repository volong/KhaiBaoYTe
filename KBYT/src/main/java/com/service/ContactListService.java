package com.service;


import com.model.ListContact;

import java.util.List;

public interface ContactListService {
    List<ListContact> findAll();

    ListContact findById(Long id);
}
