package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "MedidaCliente")
public class MedidaCliente  extends Medida{
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
