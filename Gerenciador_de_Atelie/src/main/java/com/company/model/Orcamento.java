package com.company.model;

public class Orcamento {
    private Long id;
    private Usuario usuario;
    private Cliente cliente;
    private Date dataCriacao;
    private List<ItemPedido> itensPedido;
    private Double valorTotal;
    private String observacoes;
}