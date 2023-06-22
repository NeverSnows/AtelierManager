package com.company.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "Medida")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nome;
    private String tamanho;

    public Measure() {}
    public Measure(String nome, String tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }
    public Measure(Long id, String nome, String tamanho) {
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

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}