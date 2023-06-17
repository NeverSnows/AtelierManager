package com.company.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Peca")
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Double precoBase;
    @OneToMany(mappedBy = "peca")
    private List<MedidaPeca> medidas;
    @ManyToOne
    private Modelo modelo;

    @OneToMany(mappedBy = "peca")
    private List<ItemPedido> itensPedido;

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

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<MedidaPeca> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<MedidaPeca> medidas) {
        this.medidas = medidas;
    }

}