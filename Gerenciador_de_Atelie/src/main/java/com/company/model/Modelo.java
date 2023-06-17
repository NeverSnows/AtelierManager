package com.company.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double multiplicador;
}