package com.company.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Peca")
public class Piece implements Identificavel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Double precoBase;
    @OneToMany(mappedBy = "piece")
    private List<MeasurePeca> medidas;
    @ManyToOne
    private Model modelo;

    @OneToMany(mappedBy = "piece")
    private List<OrderItem> itensPedido;

    public Piece(){}
    public Piece(String name, Double precoBase){
       this.name = name;
       this.precoBase = precoBase;
    }
    public Piece(String name, Double precoBase, List<MeasurePeca> medidas,
                 Model modelo, List<OrderItem> itensPedido) {
        this.name = name;
        this.precoBase = precoBase;
        this.medidas = medidas;
        this.modelo = modelo;
        this.itensPedido = itensPedido;
    }
    public Piece(Long id, String name, Double precoBase, List<MeasurePeca> medidas,
                 Model modelo, List<OrderItem> itensPedido) {
        this.id = id;
        this.name = name;
        this.precoBase = precoBase;
        this.medidas = medidas;
        this.modelo = modelo;
        this.itensPedido = itensPedido;
    }

    public Piece(String name, double priceDouble, List<MeasurePeca> measures, Model model) {
        this.name = name;
        this.precoBase = priceDouble;
        this.medidas = measures;
        this.modelo = model;
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

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    public Model getModelo() {
        return modelo;
    }

    public void setModelo(Model modelo) {
        this.modelo = modelo;
    }

    public List<MeasurePeca> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<MeasurePeca> medidas) {
        this.medidas = medidas;
    }

}