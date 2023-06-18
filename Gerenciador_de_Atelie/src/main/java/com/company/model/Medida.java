package com.company.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "Medida")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Medida {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nome;
    private Double tamanho;

    public Medida() {}
    public Medida(String nome, Double tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }
    public Medida(Long id, String nome, Double tamanho) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }
}