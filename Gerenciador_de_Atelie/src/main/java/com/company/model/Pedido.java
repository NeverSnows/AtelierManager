package com.company.model;

import java.util.Date;

public class Pedido extends Orcamento{
    private Date dataEntrega;
    private Boolean pago;
    private Date dataPagamento;
    private TipoPagamento tipoPagamento;
    private Situacao situacao;
}