package com.service;

import com.model.Interface.ISaticalPerson;
import com.model.Person;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;


public interface PersonService {
    Person findById(Long id);

    void save(Person person);

    void remove(Long id);

    Iterable<Person> findAll();

    Person findPersonNew();

    List<ISaticalPerson> countPersonByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
