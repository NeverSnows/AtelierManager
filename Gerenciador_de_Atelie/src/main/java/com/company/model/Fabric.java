package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "Tecido")
public class Fabric implements Identificavel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Double value;
    public Fabric() {
    }
    public Fabric(String name, Double value) {
        this.id = -1l;
        this.name = name;
        this.value = value;
    }

    public Fabric(Long id, String name, Double value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}