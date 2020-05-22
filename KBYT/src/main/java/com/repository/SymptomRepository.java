package com.repository;

import com.model.ListSymptom;
import com.model.Sick;
import com.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface SymptomRepository extends PagingAndSortingRepository<Symptom, Long> {
    @Query(value="SELECT * FROM symptom INNER JOIN listsymptom ON symptom.id_symptom = listsymptom.id_symptom WHERE id_person = :id",nativeQuery=true)
    List<Symptom> findSymptomByPersonId(@Param("id") Long id_person);

}
