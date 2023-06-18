package com.company.dao;

import com.company.model.Cliente;
import com.company.model.MedidaCliente;

import java.util.List;

public class ClienteDAO extends GenericDAO {

    @Override
    public Object buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Cliente.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }
    }
    @Override
    public List buscarTodos() {
        String instrucaoSQL = "SELECT t FROM Cliente t";
        return EntityManager.getEM().createQuery(instrucaoSQL, Cliente.class).getResultList();
    }

    @Override
    public List<Cliente> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT c FROM Cliente t WHERE c." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Cliente.class).getResultList();

    }
}
