package com.company.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pedido")
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

    public Pedido() {
    }

    public Pedido(Usuario usuario, Cliente cliente, Date dataCriacao, List<ItemPedido> itensPedido,
                  Double valorTotal, String observacoes, Long id, Date dataEntrega, Boolean pago, Date dataPagamento,
                  TipoPagamento tipoPagamento, Situacao situacao) {
        super(usuario, cliente, dataCriacao, itensPedido, valorTotal, observacoes);
        this.id = id;
        this.dataEntrega = dataEntrega;
        this.pago = pago;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
        this.situacao = situacao;
    }

    public Pedido(Long id, Usuario usuario, Cliente cliente, Date dataCriacao, List<ItemPedido> itensPedido,
                  Double valorTotal, String observacoes, Long id1, Date dataEntrega, Boolean pago, Date dataPagamento,
                  TipoPagamento tipoPagamento, Situacao situacao) {
        super(id, usuario, cliente, dataCriacao, itensPedido, valorTotal, observacoes);
        this.id = id1;
        this.dataEntrega = dataEntrega;
        this.pago = pago;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
        this.situacao = situacao;
    }


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