package com.service.impl;

import com.model.Contact;
import com.repository.ContactRepository;
import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public List<Contact> findContactByPersonId(Long id_person) {
        return contactRepository.findContactsByPersonId(id_person);
    }
}
