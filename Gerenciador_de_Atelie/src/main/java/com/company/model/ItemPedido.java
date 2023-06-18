package com.company.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "ItemPedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "peca_id")
    private Peca peca;

    @Column(name = "tamanho")
    @Enumerated(EnumType.STRING) // Mapear como string
    private Tamanho tamanho;

    @ManyToOne
    @JoinColumn(name = "tecido_id")
    private Tecido tecido;

    @Column(name = "Cor")
    private String cor;

    @OneToMany(mappedBy = "itemPedido")
    private List<Adicional> adicionais;

    @ManyToOne
    @JoinColumn(name = "orcamento_id")
    private Orcamento orcamento;

    @Column(name = "valorItem")
    private Double valorItem;

    public ItemPedido() {
    }
    public ItemPedido(Peca peca, Tamanho tamanho, Tecido tecido, String cor,
                      List<Adicional> adicionais, Orcamento orcamento, Double valorItem) {
        this.peca = peca;
        this.tamanho = tamanho;
        this.tecido = tecido;
        this.cor = cor;
        this.adicionais = adicionais;
        this.orcamento = orcamento;
        this.valorItem = valorItem;
    }
    public ItemPedido(Long id, Peca peca, Tamanho tamanho, Tecido tecido, String cor,
                      List<Adicional> adicionais, Orcamento orcamento, Double valorItem) {
        this.id = id;
        this.peca = peca;
        this.tamanho = tamanho;
        this.tecido = tecido;
        this.cor = cor;
        this.adicionais = adicionais;
        this.orcamento = orcamento;
        this.valorItem = valorItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Tecido getTecido() {
        return tecido;
    }

    public void setTecido(Tecido tecido) {
        this.tecido = tecido;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(List<Adicional> adicionais) {
        this.adicionais = adicionais;
    }

    public Double getValorItem() {
        return valorItem;
    }

    public void setValorItem(Double valorItem) {
        this.valorItem = valorItem;
    }

    //public Double calculaValorItem(Peca peca, Tecido tecido, )
}