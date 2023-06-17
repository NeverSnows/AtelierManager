package com.company.dao;

import javax.persistence.TypedQuery;
import java.util.List;

public class TecidoDTO {
    private Long id;
    private String nome;
    private Double preco;

    public TecidoDTO() {
    }

    public TecidoDTO(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


}
