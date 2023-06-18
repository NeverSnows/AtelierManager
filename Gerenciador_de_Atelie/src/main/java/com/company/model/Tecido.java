package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "Tecido")
public class Tecido implements Identificavel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private Double preco;
    public Tecido() {
    }
    public Tecido(String nome, Double preco) {
        this.id = -1l;
        this.nome = nome;
        this.preco = preco;
    }

    public Tecido(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}