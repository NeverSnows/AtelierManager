package com.company.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double multiplicador;

    public Modelo() {}
    public Modelo( String nome, Double multiplicador) {
        this.nome = nome;
        this.multiplicador = multiplicador;
    }
    public Modelo(Long id, String nome, Double multiplicador) {
        this.id = id;
        this.nome = nome;
        this.multiplicador = multiplicador;
    }
}