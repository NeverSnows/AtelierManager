package com.company.dao;

import com.company.model.Order;

import java.util.List;

public class PedidoDAO extends GenericDAO<Order>{


    public Order buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Order.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Order> buscarTodos() {
        String instrucaoSQL = "SELECT p FROM Order p";
        return EntityManager.getEM().createQuery(instrucaoSQL, Order.class).getResultList();
    }

    @Override
    public List<Order> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT p FROM Order p WHERE p." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Order.class).getResultList();
    }
}
