package com.company.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Cliente")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<MeasureCliente> medidas; // medidas do cliente

    public Customer() {
    }

    public Customer(String nome, String telefone, String email, List<MeasureCliente> medidas) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.medidas = medidas;
    }
    public Customer(Long id, String nome, String telefone, String email, List<MeasureCliente> medidas) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.medidas = medidas;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MeasureCliente> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<MeasureCliente> medidas) {
        this.medidas = medidas;
    }
}