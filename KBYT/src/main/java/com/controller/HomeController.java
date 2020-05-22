package com.controller;

import com.model.Contact;
import com.model.Person;
import com.model.Sick;
import com.model.Symptom;
import com.repository.PersonRepository;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Controller
public class HomeController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private WardService wardService;

    @Autowired
    private SickService sickService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private SymptomService symptomService;

    @Autowired
    private SickListService sickListService;
    @Autowired
    private ContactListService contactListService;
    @Autowired
    private SymptomListService symptomListService;



    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("sick", new Sick());
        model.addAttribute("contact", new Contact());
        model.addAttribute("symptom", new Symptom());
        model.addAttribute("provinces", provinceService.findAll());
        model.addAttribute("districts", districtService.findAll());
        model.addAttribute("wards", wardService.findAll());

        return "home";
    }

    @PostMapping("/save")
    public String save(Model model,@RequestParam(name = "sick", required = false) Long[] sickId, @RequestParam(name = "contact", required = false) Long[] contactId,
                       @RequestParam(name = "symptom", required = false) Long[] symptomId, Person person, RedirectAttributes redirect) {
        Set<Sick> sickSet = new HashSet<>();
        Set<Contact> contactSet = new HashSet<>();
        Set<Symptom> symptomSet = new HashSet<>();
        person.setDate(Date.valueOf(LocalDate.now()));
        personRepository.save(person);
        person = personRepository.findPersonNew();

        if (sickId != null) {
            for (int i = 0; i < sickId.length; i++) {
                Sick sick = new Sick();
                sick.setListSick(sickListService.findById(sickId[i]));
                sick.setPerson(person);
                sickService.save(sick);
            }
        }

        if (contactId != null) {
            for (int i = 0; i < contactId.length; i++) {
                Contact contact = new Contact();
                contact.setListContact(contactListService.findById(contactId[i]));
                contact.setPerson(person);
                contactService.save(contact);
            }
        }

        if (symptomId != null) {
            for (int i = 0; i < symptomId.length; i++) {
                Symptom symptom = new Symptom();
                symptom.setListSymptom(symptomListService.findById(symptomId[i]));
                symptom.setPerson(person);
                symptomService.save(symptom);
            }
        }

        redirect.addFlashAttribute("success", "Contacted");
        model.addAttribute("person", new Person());
        model.addAttribute("sick", new Sick());
        model.addAttribute("contact", new Contact());
        model.addAttribute("symptom", new Symptom());
        model.addAttribute("provinces", provinceService.findAll());
        model.addAttribute("districts", districtService.findAll());
        model.addAttribute("wards", wardService.findAll());
        model.addAttribute("hello","hello");
        return "home";
    }
}
