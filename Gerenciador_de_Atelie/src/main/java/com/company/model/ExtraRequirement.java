package com.company.model;
import javax.persistence.*;

@Entity
@Table(name = "Adicional")
public class ExtraRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double value;
    @ManyToOne
    private OrderItem orderItem;
    public ExtraRequirement(){}

    public ExtraRequirement(String name, Double value, OrderItem orderItem) {
        setName(name);
        setValue(value);
        setOrderItem(orderItem);
    }

    public ExtraRequirement(Long id, String name, Double value, OrderItem orderItem) {
        setId(id);
        setName(name);
        setValue(value);
        setOrderItem(orderItem);
    }

    public ExtraRequirement(String name, double valueDouble) {
        setName(name);
        setValue(value);
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
    public OrderItem getItemPedido() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }}
