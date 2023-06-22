package com.company.dao;

import com.company.model.MeasurePeca;

import javax.persistence.NoResultException;
import java.util.List;

public class  MedidaPecaDAO  extends GenericDAO<MeasurePeca>{
    @Override
    public MeasurePeca buscarPorId(Long id) {
        try {
            String instrucaoSQL = "SELECT i FROM MeasurePeca mp " +
                    "JOIN FETCH mp.piece " +
                    "WHERE i.id = :id";
            return EntityManager.getEM()
                    .createQuery(instrucaoSQL, MeasurePeca.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar ItemPedido por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List buscarTodos() {
        String instrucaoSQL = "SELECT mp from MeasurePeca mp";
        return EntityManager.getEM().createQuery(instrucaoSQL, MeasurePeca.class).getResultList();
    }

    @Override
    public List<MeasurePeca> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT mp FROM MeasurePeca mp WHERE mp." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, MeasurePeca.class).getResultList();
    }

}
