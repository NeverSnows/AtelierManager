package com.company.atelier_manager.structure.enums;

public enum Size {
    //Cada tamanho possui um multiplicador atrelado a ele.
    //Os valores definidos no documento da proposta de projeto estão incorretos, pois necessitam manter o preço base, mas começam em 0.
    //Corrigi eles para começarem em 1.
    PP(1),
    P(1.02),
    M(1.04),
    G(1.06),
    GG(1.08),
    EXGG(1.1);

    private final double priceMultiplier;

    Size(double priceMultiplier){
        this.priceMultiplier = priceMultiplier;
    }

    public double getPriceMultiplier(){
        return priceMultiplier;
    }
}
