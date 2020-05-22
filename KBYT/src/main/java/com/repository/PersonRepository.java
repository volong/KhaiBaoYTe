package com.repository;

import com.model.Interface.ISaticalPerson;
import com.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    @Query(value = "SELECT * FROM person order by id_person desc limit 1;", nativeQuery = true)
    Person findPersonNew();

    @Query(value= "Select count(*) as count, date as date from person  WHERE person.date >= :startDate AND person.date <= :endDate group by date", nativeQuery=true)
    List<ISaticalPerson> countPersonByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
