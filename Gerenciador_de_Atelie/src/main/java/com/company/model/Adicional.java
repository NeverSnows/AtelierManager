package com.company.model;
import javax.persistence.*;

@Entity
@Table(name = "Adicional")
public class Adicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double multiplicador;
    @ManyToOne
    private ItemPedido itemPedido;
    public Adicional(){}

    public Adicional(String nome, Double multiplicador, ItemPedido itemPedido) {
        setNome(nome);
        setMultiplicador(multiplicador);
        setItemPedido(itemPedido);
    }

    public Adicional(Long id, String nome, Double multiplicador, ItemPedido itemPedido) {
        setId(id);
        setNome(nome);
        setMultiplicador(multiplicador);
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

    public Double getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(Double multiplicador) {
        this.multiplicador = multiplicador;
    }
    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }}
