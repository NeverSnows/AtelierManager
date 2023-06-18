package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "MedidaPeca")
public class MedidaPeca extends Medida{
    @ManyToOne
    @JoinColumn(name = "peca_id")
    private Peca peca;

    // Atributos específicos das medidas da roupa

    // Getters e setters
}

