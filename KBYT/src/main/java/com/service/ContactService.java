package com.service;

import com.model.Contact;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ContactService {
    void save(Contact contact);

    Contact findById(Long id);

    List<Contact> findContactByPersonId(@Param("id") Long id_person);
}
