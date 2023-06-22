package com.company.dao;

import com.company.model.ExtraRequirement;

import javax.persistence.NoResultException;
import java.util.List;

public class AdicionalDAO extends GenericDAO<ExtraRequirement>{
    @Override
    public ExtraRequirement buscarPorId(Long id) {
        try {
            String instrucaoSQL = "SELECT a FROM Adicional a " +
                    "JOIN FETCH a.itempedido " +
                    "WHERE a.id = :id";
            return EntityManager.getEM()
                    .createQuery(instrucaoSQL, ExtraRequirement.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar Adicional por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<ExtraRequirement> buscarTodos() {
        String instrucaoSQL = "SELECT a FROM Adicional a";
        return EntityManager.getEM().createQuery(instrucaoSQL, ExtraRequirement.class).getResultList();
    }

    @Override
    public List<ExtraRequirement> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT a FROM Adicional a WHERE a." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, ExtraRequirement.class).getResultList();
    }
}
