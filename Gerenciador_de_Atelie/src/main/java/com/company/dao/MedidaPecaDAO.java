package com.company.dao;

import com.company.model.MedidaPeca;

import javax.persistence.NoResultException;
import java.util.List;

public class MedidaPecaDAO  extends GenericDAO{
    @Override
    public Object buscarPorId(Long id) {
        try {
            String instrucaoSQL = "SELECT i FROM MedidaPeca mp " +
                    "JOIN FETCH mp.cliente " +
                    "WHERE i.id = :id";
            return EntityManager.getEM()
                    .createQuery(instrucaoSQL, MedidaPeca.class)
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
        String instrucaoSQL = "SELECT mp from MedidaPeca mp";
        return EntityManager.getEM().createQuery(instrucaoSQL, MedidaPeca.class).getResultList();
    }

    @Override
    public List<MedidaPeca> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT mp FROM MedidaPeca mp WHERE mp." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, MedidaPeca.class).getResultList();
    }

}
