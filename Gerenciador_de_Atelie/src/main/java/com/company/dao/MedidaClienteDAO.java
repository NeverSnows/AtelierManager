package com.company.dao;


import com.company.model.MedidaCliente;

import javax.persistence.NoResultException;
import java.util.List;

public class MedidaClienteDAO extends GenericDAO{
    @Override
    public Object buscarPorId(Long id) {
        try {
            String instrucaoSQL = "SELECT i FROM MedidaCliente md " +
                    "JOIN FETCH md.cliente " +
                    "WHERE i.id = :id";
            return EntityManager.getEM()
                    .createQuery(instrucaoSQL, MedidaCliente.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar ItemPedido por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List buscarTodos() {
        String instrucaoSQL = "SELECT md from MedidaCliente md";
        return EntityManager.getEM().createQuery(instrucaoSQL, MedidaCliente.class).getResultList();
    }

    @Override
    public List<MedidaCliente> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT md FROM MedidaCliente md WHERE md." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, MedidaCliente.class).getResultList();
    }
}
