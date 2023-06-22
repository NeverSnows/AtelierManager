package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "MedidaPeca")
public class MeasurePeca extends Measure {
    @ManyToOne
    @JoinColumn(name = "peca_id")
    private Piece piece;

    public MeasurePeca(Piece piece) {
        this.piece = piece;
    }

    public MeasurePeca(String nome, String tamanho, Piece piece) {
        super(nome, tamanho);
        this.piece = piece;
    }

    public MeasurePeca(Long id, String nome, String tamanho, Piece piece) {
        super(id, nome, tamanho);
        this.piece = piece;
    }

    public MeasurePeca(String name, String value) {
        super(name, value);

    }


    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}

