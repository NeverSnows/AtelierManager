package com.company.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Cliente")
public class Customer implements Identificavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<MeasureCliente> measures; // medidas do cliente

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String email, List<MeasureCliente> measures) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.measures = measures;
    }
    public Customer(Long id, String name, String phoneNumber, String email, List<MeasureCliente> measures) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.measures = measures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<MeasureCliente> getMeasures() {
        return measures;
    }

    public void setMeasures(List<MeasureCliente> measures) {
        this.measures = measures;
    }
}