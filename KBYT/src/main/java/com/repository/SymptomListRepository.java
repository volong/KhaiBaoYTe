package com.repository;

import com.model.Interface.ISaticalSymptom;
import com.model.ListSymptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.util.List;

public interface SymptomListRepository extends PagingAndSortingRepository<ListSymptom, Long> {
    @Query(value=" SELECT count(*) as count,listsymptom.symptom as listSymptom FROM project.symptom inner join project.listsymptom on symptom.id_symptom=listsymptom.id_symptom inner join person on symptom.id_person = person.id_person WHERE person.date >= :startDate AND person.date <= :endDate group by symptom.id_symptom;", nativeQuery = true)
    List<ISaticalSymptom> countListSymptom(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
