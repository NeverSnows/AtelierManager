package com.company.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    // Atributos específicos das medidas da roupa

    // Getters e setters
}
