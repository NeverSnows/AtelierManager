package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "MedidaCliente")
public class MeasureCliente extends Measure {


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Customer customer;

    public MeasureCliente() {
    }

    public MeasureCliente(String nome, String tamanho, Customer customer) {
        super(nome, tamanho);
        this.customer = customer;
    }

    public MeasureCliente(Long id, String nome, String tamanho, Customer customer) {
        super(id, nome, tamanho);
        this.customer = customer;
    }

    public MeasureCliente(String name, String value) {
        super(name, value);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
