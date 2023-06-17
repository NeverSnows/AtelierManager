package com.company.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Pedido")
@PrimaryKeyJoinColumn(name = "orcamento_id")
public class Pedido extends Orcamento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_entrega")
    private Date dataEntrega;

    @Column(name = "pago")
    private Boolean pago;

    @Column(name = "data_pagamento")
    private Date dataPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento")
    private TipoPagamento tipoPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private Situacao situacao;


    public Date getDataEntrega() {
        return dataEntrega;
    }

    public Boolean getPago() {
        return pago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}