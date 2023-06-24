package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "Modelo")
public class Model implements Identificavel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double value;
    public Model() {}
    public Model(String nome, Double value) {
        this.name = nome;
        this.value = value;
    }
    public Model(Long id, String nome, Double value) {
        this.id = id;
        this.name = nome;
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