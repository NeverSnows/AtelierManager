package com.company.model;

import java.util.Date;

public class Pedido extends Orcamento{
    private Date dataEntrega;
    private Boolean pago;
    private Date dataPagamento;
    private TipoPagamento tipoPagamento;
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
}