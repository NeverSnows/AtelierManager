package com.company.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MedidaCliente")
public class MedidaCliente  extends Medida{
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public MedidaCliente() {
    }

    public MedidaCliente(String nome, Double tamanho, Cliente cliente) {
        super(nome, tamanho);
        this.cliente = cliente;
    }

    public MedidaCliente(Long id, String nome, Double tamanho, Cliente cliente) {
        super(id, nome, tamanho);
        this.cliente = cliente;
    }

    // Atributos específicos das medidas da roupa

    // Getters e setters
}
