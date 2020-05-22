package com.controller;


import com.model.Interface.ISaticalPerson;
import com.model.Interface.ISaticalSymptom;
import com.model.ListSymptom;
import com.model.Person;
import com.repository.SymptomListRepository;
import com.service.PersonService;
import com.service.SymptomListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/json")
public class ChartController {

    @Autowired
    private SymptomListService symptomListService;

    @Autowired
    private PersonService personService;


    @GetMapping("/countsymptom/{startDate}/{endDate}")
    public ResponseEntity<List<ISaticalSymptom>> countSymptom(
            @PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate) {
        List<ISaticalSymptom> symptoms =  symptomListService.countListSymptom(startDate, endDate);

        return new ResponseEntity<List<ISaticalSymptom>>(symptoms, HttpStatus.OK);
    }

    @GetMapping("/countperson/{startDate}/{endDate}")
    public ResponseEntity<List<ISaticalPerson>> countPersonByDate(
            @PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate) {
        List<ISaticalPerson> persons = personService.countPersonByDate(startDate, endDate);
        return new ResponseEntity<List<ISaticalPerson>>(persons, HttpStatus.OK);
    }
}
