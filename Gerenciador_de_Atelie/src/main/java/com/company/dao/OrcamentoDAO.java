package com.company.dao;

import com.company.model.Estimate;
import com.company.model.Fabric;

import java.util.List;

public class OrcamentoDAO extends GenericDAO<Estimate>{
    @Override
    public Estimate buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Estimate.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List buscarTodos() {
        String instrucaoSQL = "SELECT t FROM Estimate t";
        return EntityManager.getEM().createQuery(instrucaoSQL, Estimate.class).getResultList();

    }

    @Override
    public List<Estimate> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT o FROM Estimate o WHERE o." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Estimate.class).getResultList();
    }
}
