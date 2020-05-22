package com.service.impl;

import com.model.ListContact;
import com.repository.ContactListRepository;
import com.service.ContactListService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContactListServiceImpl implements ContactListService {
    @Autowired
    private ContactListRepository contactListRepository;

    @Override
    public List<ListContact> findAll() {
        return contactListRepository.findAll();
    }

    @Override
    public ListContact findById(Long id) {
        return contactListRepository.findById(id).get();
    }
}
