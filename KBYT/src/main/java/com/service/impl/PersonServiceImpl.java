package com.service.impl;

import com.model.Interface.ISaticalPerson;
import com.model.Person;
import com.repository.PersonRepository;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void remove(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person findPersonNew() {
        return personRepository.findPersonNew();
    }

    @Override
    public List<ISaticalPerson> countPersonByDate(Date startDate, Date endDate) {
        return personRepository.countPersonByDate(startDate, endDate);
    }


}
