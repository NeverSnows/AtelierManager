package com.company.model;

import javax.persistence.*;

public enum Tamanho {
    PP(1.00),
    P(1.02),
    M(1.04),
    G(1.06),
    GG(1.08),
    EXGG(1.10);

    Tamanho(double multiplicador) {
        this.multiplicador = multiplicador;
    }
    private double multiplicador;


    public double getMultiplicador() {
        return multiplicador;
    }
}
