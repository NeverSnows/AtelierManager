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
    private Double value;
    @OneToMany(mappedBy = "piece", cascade = CascadeType.ALL)
    private List<MeasurePeca> measures;
    @ManyToOne
    private Model model;

    @OneToMany(mappedBy = "piece", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public Piece(){}
    public Piece(String name, Double value){
       this.name = name;
       this.value = value;
    }
    public Piece(String name, Double value, List<MeasurePeca> measures,
                 Model model, List<OrderItem> orderItems) {
        this.name = name;
        this.value = value;
        this.measures = measures;
        this.model = model;
        this.orderItems = orderItems;
    }
    public Piece(Long id, String name, Double value, List<MeasurePeca> measures,
                 Model model, List<OrderItem> orderItems) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.measures = measures;
        this.model = model;
        this.orderItems = orderItems;
    }
    public Piece(long id, String name, double value, List<MeasurePeca> measures, Model model) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.measures = measures;
        this.model = model;
    }
    public Piece(String name, double value, List<MeasurePeca> measures, Model model) {
        this.name = name;
        this.value = value;
        this.measures = measures;
        this.model = model;
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public List<MeasurePeca> getMeasures() {
        return measures;
    }

    public void setMeasures(List<MeasurePeca> measures) {
        this.measures = measures;
    }

    public String getModelName(){
        return this.model.getName();
    }
}