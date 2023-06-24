package com.company.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "ItemPedido")
public class OrderItem implements Identificavel{

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
    private Color color;

    @OneToMany(mappedBy = "orderItem")
    private List<ExtraRequirement> extraRequirements;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Estimate getEstimate() {
        return estimate;
    }

    public void setEstimate(Estimate estimate) {
        this.estimate = estimate;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @ManyToOne
    @JoinColumn(name = "orcamento_id")
    private Estimate estimate;

    @Column(name = "valorItem")
    private Double totalPrice;

    public OrderItem() {
    }

    public OrderItem(Piece piece, Size size, Fabric fabric, Color color, List<ExtraRequirement> extraRequirements) {
        this.piece = piece;
        this.size = size;
        this.fabric = fabric;
        this.color = color;
        this.extraRequirements = extraRequirements;
        updateTotalPrice();
    }

    public void updateTotalPrice(){
        totalPrice = 0.0;
        totalPrice += piece.getValue();
        totalPrice += fabric.getValue();

        for(ExtraRequirement extraRequirement : extraRequirements){
            totalPrice += extraRequirement.getValue();
        }
        totalPrice *= size.getPriceMultiplier();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        updateTotalPrice();
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
        updateTotalPrice();
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
        updateTotalPrice();
    }

    public List<ExtraRequirement> getExtraRequirements() {
        updateTotalPrice();
        return extraRequirements;
    }

    public void setExtraRequirements(List<ExtraRequirement> extraRequirements) {
        this.extraRequirements = extraRequirements;
        updateTotalPrice();
    }

    public Double getTotalPrice() {
        return totalPrice;
    }


}