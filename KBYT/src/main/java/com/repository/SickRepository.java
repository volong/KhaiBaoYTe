package com.repository;

import com.model.Sick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SickRepository extends PagingAndSortingRepository<Sick, Long> {
    @Query(value="SELECT * FROM sick INNER JOIN listsick ON sick.id_sick = listsick.id_sick WHERE id_person = :id",nativeQuery=true)
    List<Sick> findSicksByPersonId(@Param("id") Long id_person);
}

