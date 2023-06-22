package com.company.model;
import javax.persistence.*;

@Entity
@Table(name = "Adicional")
public class ExtraRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valorAdicional;
    @ManyToOne
    private OrderItem orderItem;
    public ExtraRequirement(){}

    public ExtraRequirement(String nome, Double valorAdicional, OrderItem orderItem) {
        setNome(nome);
        setValorAdicional(valorAdicional);
        setItemPedido(orderItem);
    }

    public ExtraRequirement(Long id, String nome, Double valorAdicional, OrderItem orderItem) {
        setId(id);
        setNome(nome);
        setValorAdicional(valorAdicional);
        setItemPedido(orderItem);
    }

    public ExtraRequirement(String name, double valueDouble) {
        setNome(nome);
        setValorAdicional(valorAdicional);
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

    public Double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(Double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }
    public OrderItem getItemPedido() {
        return orderItem;
    }

    public void setItemPedido(OrderItem orderItem) {
        this.orderItem = orderItem;
    }}
