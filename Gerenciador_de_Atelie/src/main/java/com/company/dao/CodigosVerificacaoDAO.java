package com.company.dao;

import com.company.model.Usuario;
import com.company.model.Util.CodigosVerificacao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import java.time.LocalDateTime;

import static com.company.model.Util.CodigosVerificacao.gerarCodigoVerificacao;

public class CodigosVerificacaoDAO<T> {

    public void inserir(T entidade){
        try {
            EntityManager.getEM().getTransaction().begin();
            EntityManager.getEM().merge(entidade);
            EntityManager.getEM().getTransaction().commit();
        } catch (Exception e) {
            EntityManager.getEM().getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar a entidade: " + e.getMessage(), e);
        }
    }

    public String buscaCodigo(String codigo){
        TypedQuery<com.company.model.Util.CodigosVerificacao> instrucaoSQL = EntityManager.getEM().createQuery(
                "SELECT c FROM CodigosVerificacao c where c.codigo = :codigo",
                CodigosVerificacao.class);
        instrucaoSQL.setParameter("codigo", codigo);

        String codigoVerificado;

        try {
            CodigosVerificacao cv = instrucaoSQL.getSingleResult();
            codigoVerificado = cv.getCodigo();
            if(!cv.isFoiUsado())
                return codigoVerificado;
        } catch (NoResultException e) {
            return null;
        }

        return codigo;
    }
    public CodigosVerificacao buscaCodigoPorEmail(String email) {
        TypedQuery<CodigosVerificacao> query = EntityManager.getEM().createQuery(
                "SELECT c FROM CodigosVerificacao c WHERE c.email = :email",
                CodigosVerificacao.class);
        query.setParameter("email", email);

        CodigosVerificacao codigo = null;

        try {
            codigo = query.getSingleResult();
            codigo.setCodigo(gerarCodigoVerificacao());
            codigo.setHorarioCriacao(LocalDateTime.now());
            codigo.setFoiUsado(false);
            EntityManager.getEM().merge(codigo);
        } catch (NoResultException e) {
            // Se nenhum registro foi encontrado, insira um novo registro
            codigo = new CodigosVerificacao(email);
            EntityManager.getEM().persist(codigo);
        }

        return codigo;
    }

    public void atualizarCodigo(String email) {
        CodigosVerificacao codigo = buscaCodigoPorEmail(email);
        EntityManager.getEM().remove(codigo);
    }

    public static void main(String[] args) {
        CodigosVerificacaoDAO cvd =new CodigosVerificacaoDAO();
        cvd.atualizarCodigo("raissalagess@gmail.com");
    }
}
