package com.company.dao;

import com.company.model.Usuario;
import com.company.model.Util.CodigosVerificacao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class CodigosVerificacaoDAO<T> {

    public void inserir(T entidade){
        try {
            EntityManager.getEM().getTransaction().begin();
            EntityManager.getEM().persist(entidade);
            EntityManager.getEM().getTransaction().commit();
        } catch (Exception e) {
            EntityManager.getEM().getTransaction().rollback();
            throw new RuntimeException("Erro ao inserir a entidade: " + e.getMessage(), e);
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

            return codigoVerificado;
        } catch (NoResultException e) {
            return null;
        }
    }


}
