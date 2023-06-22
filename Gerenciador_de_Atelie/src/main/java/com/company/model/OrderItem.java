package com.company.model;

import com.company.atelier_manager.structure.ExtraRequirementt;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "ItemPedido")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "peca_id")
    private Piece piece;

    @Column(name = "tamanho")
    @Enumerated(EnumType.STRING) // Mapear como string
    private Size size;

    @ManyToOne
    @JoinColumn(name = "tecido_id")
    private Fabric fabric;

    @Column(name = "Cor")
    private String cor;

    @OneToMany(mappedBy = "orderItem")
    private List<ExtraRequirement> adicionais;

    @ManyToOne
    @JoinColumn(name = "orcamento_id")
    private Estimate estimate;

    @Column(name = "valorItem")
    private Double valorItem;

    public OrderItem() {
    }
    public OrderItem(Piece piece, Size size, Fabric fabric, String cor,
                     List<ExtraRequirement> adicionais, Estimate estimate, Double valorItem) {
        this.piece = piece;
        this.size = size;
        this.fabric = fabric;
        this.cor = cor;
        this.adicionais = adicionais;
        this.estimate = estimate;
        this.valorItem = valorItem;
    }
    public OrderItem(Long id, Piece piece, Size size, Fabric fabric, String cor,
                     List<ExtraRequirement> adicionais, Estimate estimate, Double valorItem) {
        this.id = id;
        this.piece = piece;
        this.size = size;
        this.fabric = fabric;
        this.cor = cor;
        this.adicionais = adicionais;
        this.estimate = estimate;
        this.valorItem = valorItem;
    }

    public OrderItem(Piece piece, Size size, Fabric fabric, Color color, List<ExtraRequirement> extraRequirements) {
    }

    public void atualizarPrecoTotal(){
        valorItem = 0.0;
        valorItem += piece.getPrecoBase() + fabric.getPreco();
        for(ExtraRequirement extraRequirement : adicionais)
            valorItem += extraRequirement.getValorAdicional();

        valorItem *= size.getMultiplicador();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Piece getPeca() {
        return piece;
    }

    public void setPeca(Piece piece) {
        this.piece = piece;
        atualizarPrecoTotal();
    }

    public Size getTamanho() {
        return size;
    }

    public void setTamanho(Size size) {
        this.size = size;
        atualizarPrecoTotal();
    }

    public Fabric getTecido() {
        return fabric;
    }

    public void setTecido(Fabric fabric) {
        this.fabric = fabric;
        atualizarPrecoTotal();
    }

    public List<ExtraRequirement> getAdicionais() {
        atualizarPrecoTotal();
        return adicionais;
    }

    public void setAdicionais(List<ExtraRequirement> adicionais) {
        this.adicionais = adicionais;
        atualizarPrecoTotal();
    }

    public Double getValorItem() {
        return valorItem;
    }

    public void setValorItem(Double valorItem) {
        this.valorItem = valorItem;
    }

    public Double calculaValorItem(){
       return this.piece.getPrecoBase() + this.fabric.getPreco() ;
    }
}