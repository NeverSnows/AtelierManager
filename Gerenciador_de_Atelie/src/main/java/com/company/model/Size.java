package com.company.model;

public enum Size {
    PP(1.00),
    P(1.02),
    M(1.04),
    G(1.06),
    GG(1.08),
    EXGG(1.10);

    Size(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }
    private final double priceMultiplier;


    public double getPriceMultiplier() {
        return priceMultiplier;
    }
}
