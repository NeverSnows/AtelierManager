package com.company.dao;

import com.company.model.Model;

import java.util.List;

public class ModeloDAO extends GenericDAO<Model>{
    @Override
    public Model buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Model.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar modelo por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Model> buscarTodos() {
        String instrucaoSQL = "SELECT p FROM Model p";
        return EntityManager.getEM().createQuery(instrucaoSQL, Model.class).getResultList();

    }

    @Override
    public List<Model> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT m FROM Model m WHERE m." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Model.class).getResultList();
    }
}
