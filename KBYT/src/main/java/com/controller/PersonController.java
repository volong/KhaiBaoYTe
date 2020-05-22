package com.controller;


import com.model.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/json")
public class PersonController {

    @Autowired
    private SickListService sickListService;
    @Autowired
    private SymptomListService symptomListService;
    @Autowired
    private ContactListService contactListService;

    @Autowired
    private SickService sickService;
    @Autowired
    private SymptomService symptomService;
    @Autowired
    private ContactService contactService;

    @GetMapping("/list/sick")
    public ResponseEntity<List<ListSick>> listSick() {
        List<ListSick> sicks = sickListService.findAll();
        if (sicks.isEmpty()) {
            return new ResponseEntity<List<ListSick>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ListSick>>(sicks, HttpStatus.OK);
    }

    @GetMapping("/list/contact")
    public ResponseEntity<List<ListContact>> listContact() {
        List<ListContact> contacts = contactListService.findAll();
        if (contacts.isEmpty()) {
            return new ResponseEntity<List<ListContact>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ListContact>>(contacts, HttpStatus.OK);
    }

    @GetMapping("/list/symptom")
    public ResponseEntity<Iterable<ListSymptom>> listSymptom() {
        Iterable<ListSymptom> symptoms = symptomListService.findAll();
        if (symptoms == null) {
            return new ResponseEntity<Iterable<ListSymptom>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<ListSymptom>>(symptoms, HttpStatus.OK);
    }

    @PostMapping("/sick")
    public ResponseEntity<Sick> saveSick(@RequestBody Sick sick, UriComponentsBuilder uriComponentsBuilder) {
        try {
            sickService.save(sick);
            return new ResponseEntity<Sick>(sick, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Sick>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact, UriComponentsBuilder uriComponentsBuilder) {
        try {
            contactService.save(contact);
            return new ResponseEntity<Contact>(contact, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/symptom")
    public ResponseEntity<Symptom> saveSymptom(@RequestBody Symptom symptom, UriComponentsBuilder uriComponentsBuilder) {
        try {
            symptomService.save(symptom);
            return new ResponseEntity<Symptom>(symptom, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Symptom>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/sick/{id_person}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Sick>> findSicksByPersonId(@PathVariable("id_person") Long id_person) {
        List<Sick> sicks = sickService.findSicksByPersonId(id_person);
        if (sicks == null) {
            return new ResponseEntity<List<Sick>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Sick>>(sicks, HttpStatus.OK);
    }

    @GetMapping(value = "/contact/{id_person}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>> findContactByPersonId(@PathVariable("id_person") Long id_person) {
        List<Contact> contacts = contactService.findContactByPersonId(id_person);
        if (contacts == null) {
            return new ResponseEntity<List<Contact>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
    }

    @GetMapping(value = "/symptom/{id_person}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Symptom>> findSymptomsByPersonId(@PathVariable("id_person") Long id_person) {
        List<Symptom> symptoms = symptomService.findSymptomByPersonId(id_person);
        if (symptoms == null) {
            return new ResponseEntity<List<Symptom>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Symptom>>(symptoms, HttpStatus.OK);
    }
}