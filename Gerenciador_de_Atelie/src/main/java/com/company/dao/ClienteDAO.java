package com.company.dao;

import com.company.model.Customer;

import java.util.List;

public class ClienteDAO extends GenericDAO <Customer>{

    @Override
    public Customer buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Customer.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }
    }
    @Override
    public List<Customer> buscarTodos() {
        String instrucaoSQL = "SELECT t FROM Customer t";
        return EntityManager.getEM().createQuery(instrucaoSQL, Customer.class).getResultList();
    }

    @Override
    public List<Customer> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT c FROM Customer t WHERE c." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Customer.class).getResultList();

    }
}
