package com.repository;

import com.model.ListSick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SickListRepository extends JpaRepository<ListSick, Long> {
}
