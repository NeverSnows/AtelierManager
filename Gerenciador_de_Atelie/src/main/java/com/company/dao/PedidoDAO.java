package com.company.dao;

import com.company.model.Identificavel;
import com.company.model.Pedido;
import com.company.model.Tecido;
import com.company.model.Usuario;

import java.util.List;

public class PedidoDAO extends GenericDAO{


    public Object buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Pedido.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List buscarTodos() {
        String instrucaoSQL = "SELECT p FROM Pedido p";
        return EntityManager.getEM().createQuery(instrucaoSQL, Pedido.class).getResultList();
    }

    @Override
    public List<Pedido> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT p FROM Pedido p WHERE p." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Pedido.class).getResultList();
    }
}
