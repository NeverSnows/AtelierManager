package com.company.atelier_manager.structure;

import java.util.List;

public class Customer {
    private final long id;
    private String name;
    private String phoneNumber;
    private String email;
    private List<Measure> measures;

    public Customer(long id, String name, String phoneNumber, String email, List<Measure> measures) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.measures = measures;
    }
    public Customer(String name, String phoneNumber, String email, List<Measure> measures) {
        this.id = -1;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.measures = measures;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }
}
