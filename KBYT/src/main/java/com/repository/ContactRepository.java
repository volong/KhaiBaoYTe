package com.repository;


import com.model.Contact;
import com.model.Sick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
    @Query(value="SELECT * FROM contact INNER JOIN listcontact ON contact.id_contact = listcontact.id_contact WHERE id_person = :id",nativeQuery=true)
    List<Contact> findContactsByPersonId(@Param("id") Long id_person);
}
