package com.company.dao;

import com.company.model.Piece;

import java.util.List;

public class PecaDAO extends GenericDAO<Piece>{
    @Override
    public Piece buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Piece.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }    }

    @Override
    public List buscarTodos() {
        String instrucaoSQL = "SELECT p FROM Piece p";
        return EntityManager.getEM().createQuery(instrucaoSQL, Piece.class).getResultList();
    }

    @Override
    public List<?> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT p FROM Piece p WHERE p." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Piece.class).getResultList();
    }
}
