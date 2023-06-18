package com.company.model.Util;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "codigosverificacao")
public class CodigosVerificacao {

    @Id
    private String email;

    private String codigo;

    private LocalDateTime horarioCriacao;

    private boolean foiUsado;

    public CodigosVerificacao(){}
    public CodigosVerificacao(String email){
        this.codigo = gerarCodigoVerificacao();
        this.horarioCriacao = LocalDateTime.now();
        this.foiUsado = false;
    }

    public static String gerarCodigoVerificacao() {
        Random random = new Random();
        int randomNumber = random.nextInt(90000000) + 10000000; // Gera um número aleatório entre 10000000 e 99999999
        return String.valueOf(randomNumber);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getHorarioCriacao() {
        return horarioCriacao;
    }

    public void setHorarioCriacao(LocalDateTime horarioCriacao) {
        this.horarioCriacao = horarioCriacao;
    }

    public boolean isFoiUsado() {
        return foiUsado;
    }

    public void setFoiUsado(boolean foiUsado) {
        this.foiUsado = foiUsado;
    }
}
