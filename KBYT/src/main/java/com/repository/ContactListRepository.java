package com.repository;

import com.model.ListContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactListRepository extends JpaRepository<ListContact, Long> {
}
