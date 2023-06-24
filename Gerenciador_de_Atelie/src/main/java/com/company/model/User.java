package com.company.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"emailUsuario"}))
public class User implements Serializable, Identificavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nomeUsuario")
    private String name;
    @Column(name = "emailUsuario")
    private String email;
    @Column(name = "senhaUsuario")
    private String pasword;

    public User(){}

    public User(Long id, String name, String email, String pasword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pasword = pasword;
    }
    public User(String name, String email, String pasword) {
        this.name = name;
        this.email = email;
        this.pasword = pasword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nomeUsuario='" + name + '\'' +
                ", emailUsuario='" + email + '\'' +
                ", senhaUsuario='" + pasword + '\'' +
                '}';
    }


}