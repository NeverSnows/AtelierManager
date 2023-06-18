package com.company.model;
import javax.persistence.*;

@Entity
@Table(name = "Adicional")
public class Adicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valorAdicional;
    @ManyToOne
    private ItemPedido itemPedido;
    public Adicional(){}

    public Adicional(String nome, Double valorAdicional, ItemPedido itemPedido) {
        setNome(nome);
        setValorAdicional(valorAdicional);
        setItemPedido(itemPedido);
    }

    public Adicional(Long id, String nome, Double valorAdicional, ItemPedido itemPedido) {
        setId(id);
        setNome(nome);
        setValorAdicional(valorAdicional);
        setItemPedido(itemPedido);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(Double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }
    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }}
