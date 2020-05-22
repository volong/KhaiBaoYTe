package com.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "symptom")
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_person", unique = true)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_symptom")
    private ListSymptom listSymptom;

    public Symptom() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_symptoms) {
        this.id = id_symptoms;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ListSymptom getListSymptom() {
        return listSymptom;
    }

    public void setListSymptom(ListSymptom listSymptom) {
        this.listSymptom = listSymptom;
    }
}
