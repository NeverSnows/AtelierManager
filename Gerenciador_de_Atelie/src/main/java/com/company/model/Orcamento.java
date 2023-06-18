package com.company.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Orcamento")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Cliente cliente;
    private Date dataCriacao;
    @OneToMany(mappedBy = "orcamento")

    private List<ItemPedido> itensPedido;
    private Double valorTotal;
    private String observacoes;

    public Orcamento(){}

    public Orcamento(Usuario usuario, Cliente cliente, Date dataCriacao,
                     List<ItemPedido> itensPedido, String observacoes) {
        this.usuario = usuario;
        this.cliente = cliente;
        this.dataCriacao = dataCriacao;
        this.itensPedido = itensPedido;
        this.observacoes = observacoes;
        atualizarPrecoTotal();

    }

    public Orcamento(Long id, Usuario usuario, Cliente cliente, Date dataCriacao,
                     List<ItemPedido> itensPedido, String observacoes) {
        this.id = id;
        this.usuario = usuario;
        this.cliente = cliente;
        this.dataCriacao = dataCriacao;
        this.itensPedido = itensPedido;
        this.observacoes = observacoes;
        atualizarPrecoTotal();
    }

    private void atualizarPrecoTotal(){
        valorTotal = 0.0;
        for(ItemPedido itemPedido : itensPedido)
            valorTotal += itemPedido.getValorItem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<ItemPedido> getItensPedido() {
        atualizarPrecoTotal();
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
        atualizarPrecoTotal();

    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}