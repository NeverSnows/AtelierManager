package com.company.dao;

import com.company.model.ItemPedido;
import com.company.model.Peca;
import com.company.model.Tecido;

import javax.persistence.NoResultException;
import java.util.List;

public class ItemPedidoDAO extends GenericDAO<ItemPedido> {
    @Override
    public ItemPedido buscarPorId(Long id) {
        try {
            String instrucaoSQL = "SELECT i FROM ItemPedido i " +
                    "JOIN FETCH i.tecido " +
                    "JOIN FETCH i.peca " +
                    "WHERE i.id = :id";
            return EntityManager.getEM()
                    .createQuery(instrucaoSQL, ItemPedido.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar ItemPedido por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<ItemPedido> buscarTodos() {
        String instrucaoSQL = "SELECT t FROM ItemPedido t";
        return EntityManager.getEM().createQuery(instrucaoSQL, ItemPedido.class).getResultList();
    }

    @Override
    public List<ItemPedido> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT i FROM ItemPedido i WHERE i." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, ItemPedido.class).getResultList();
    }

}
