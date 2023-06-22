package com.company.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Orcamento")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;
    @ManyToOne
    private Customer customer;
    private Date dataCriacao;
    @OneToMany(mappedBy = "estimate")

    private List<OrderItem> itensPedido;
    private Double valorTotal;
    private String observacoes;

    public Estimate(){}

    public Estimate(User user, Customer customer, Date dataCriacao,
                    List<OrderItem> itensPedido, String observacoes) {
        this.user = user;
        this.customer = customer;
        this.dataCriacao = dataCriacao;
        this.itensPedido = itensPedido;
        this.observacoes = observacoes;
        atualizarPrecoTotal();
    }

    public Estimate(Long id, User user, Customer customer, Date dataCriacao,
                    List<OrderItem> itensPedido, String observacoes) {
        this.id = id;
        this.user = user;
        this.customer = customer;
        this.dataCriacao = dataCriacao;
        this.itensPedido = itensPedido;
        this.observacoes = observacoes;
        atualizarPrecoTotal();
    }

    public Estimate(Long id, User usuario, Customer cliente, Date dataCriacao, List<OrderItem> itensPedido, Double valorTotal, String observacoes) {
    }

    private void atualizarPrecoTotal(){
        valorTotal = 0.0;
        for(OrderItem orderItem : itensPedido)
            valorTotal += orderItem.getValorItem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario() {
        return user;
    }

    public void setUsuario(User user) {
        this.user = user;
    }

    public Customer getCliente() {
        return customer;
    }

    public void setCliente(Customer customer) {
        this.customer = customer;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<OrderItem> getItensPedido() {
        atualizarPrecoTotal();
        return itensPedido;
    }

    public void setItensPedido(List<OrderItem> itensPedido) {
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