package com.company.dao;


import com.company.model.MeasureCliente;

import javax.persistence.NoResultException;
import java.util.List;

public class MedidaClienteDAO extends GenericDAO<MeasureCliente>{
    @Override
    public MeasureCliente buscarPorId(Long id) {
        try {
            String instrucaoSQL = "SELECT i FROM MeasureCliente md " +
                    "JOIN FETCH md.customer " +
                    "WHERE i.id = :id";
            return EntityManager.getEM()
                    .createQuery(instrucaoSQL, MeasureCliente.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar MeasureCliente por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List buscarTodos() {
        String instrucaoSQL = "SELECT md from MeasureCliente md";
        return EntityManager.getEM().createQuery(instrucaoSQL, MeasureCliente.class).getResultList();
    }

    @Override
    public List<MeasureCliente> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT md FROM MeasureCliente md WHERE md." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, MeasureCliente.class).getResultList();
    }
}
