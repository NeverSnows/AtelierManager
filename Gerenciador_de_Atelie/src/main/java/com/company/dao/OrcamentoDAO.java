package com.company.dao;

import com.company.model.Orcamento;
import com.company.model.Tecido;

import java.util.List;

public class OrcamentoDAO extends GenericDAO{
    @Override
    public Object buscarPorId(Long id) {
        String instrucaoSQL = "SELECT o FROM Orcamento o";
        return EntityManager.getEM().createQuery(instrucaoSQL, Orcamento.class).getResultList();
    }

    @Override
    public List buscarTodos() {
        String instrucaoSQL = "SELECT t FROM Tecido t";
        return EntityManager.getEM().createQuery(instrucaoSQL, Orcamento.class).getResultList();

    }

    @Override
    public List<Orcamento> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT o FROM Orcamento o WHERE o." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Orcamento.class).getResultList();
    }
}
