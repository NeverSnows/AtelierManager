package com.company.dao;

import com.company.model.OrderItem;

import javax.persistence.NoResultException;
import java.util.List;

public class ItemPedidoDAO extends GenericDAO<OrderItem> {
    @Override
    public OrderItem buscarPorId(Long id) {
        try {
            String instrucaoSQL = "SELECT i FROM OrderItem i " +
                    "JOIN FETCH i.fabric " +
                    "JOIN FETCH i.piece " +
                    "WHERE i.id = :id";
            return EntityManager.getEM()
                    .createQuery(instrucaoSQL, OrderItem.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar ItemPedido por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<OrderItem> buscarTodos() {
        String instrucaoSQL = "SELECT t FROM OrderItem t";
        return EntityManager.getEM().createQuery(instrucaoSQL, OrderItem.class).getResultList();
    }

    @Override
    public List<OrderItem> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT i FROM OrderItem i WHERE i." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, OrderItem.class).getResultList();
    }

}
