package com.company.dao;

import com.company.model.Peca;
import com.company.model.Tecido;

import java.util.List;

public class PecaDAO extends GenericDAO{
    @Override
    public Object buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Peca.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }    }

    @Override
    public List buscarTodos() {
        String instrucaoSQL = "SELECT p FROM Peca p";
        return EntityManager.getEM().createQuery(instrucaoSQL, Peca.class).getResultList();
    }

    @Override
    public List<?> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT p FROM Peca p WHERE p." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Peca.class).getResultList();
    }
}
