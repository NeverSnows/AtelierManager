package com.company.model;

import javax.persistence.*;

public enum Tamanho {
    PP(0.00),
    P(0.02),
    M(0.04),
    G(0.06),
    GG(0.08),
    EXGG(0.10);

    Tamanho(double multiplicador) {
        this.multiplicador = multiplicador;
    }
    private double multiplicador;


    public double getMultiplicador() {
        return multiplicador;
    }
}
