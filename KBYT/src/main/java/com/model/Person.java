package com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_person;
    private String passportNumber;
    private String fullName;
    private int yob;
    private String gender;
    private String phoneNumber;
    private String email;
    private String street;                  //đường, thôn, xóm.....
    private String actIn14days;             //action trong vòng 14 ngày qua
    private int khaiho;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_province")
    private Province province;

    @ManyToOne
    @JoinColumn(name = "id_district")
    private District district;

    @ManyToOne
    @JoinColumn(name = "id_ward")
    private Ward ward;

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private Set<Sick> sicks;

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private Set<Contact> contacts;

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private Set<Symptom> symptoms;


    public Person() {
    }

    public Person(String passportNumber, String fullName, String gender, int yob, String phoneNumber,
                  String email, String street, String actIn14days, int khaiho, Date date) {
        this.passportNumber = passportNumber;
        this.fullName = fullName;
        this.gender = gender;
        this.yob = yob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.street = street;
        this.actIn14days = actIn14days;
        this.khaiho = khaiho;
        this.date = date;
    }

    public Long getId_person() {
        return id_person;
    }

    public void setId_person(Long id) {
        this.id_person = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getActIn14days() {
        return actIn14days;
    }

    public void setActIn14days(String actIn14days) {
        this.actIn14days = actIn14days;
    }

    public int getKhaiho() {
        return khaiho;
    }

    public void setKhaiho(int khaiho) {
        this.khaiho = khaiho;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    //Getter and Setter for National, District, Province, Ward


    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Set<Sick> getSicks() {
        return sicks;
    }

    public void setSicks(Set<Sick> sicks) {
        this.sicks = sicks;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Set<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

}
