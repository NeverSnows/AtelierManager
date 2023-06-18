package com.company.dao;

import com.company.model.Adicional;
import com.company.model.ItemPedido;
import com.company.model.MedidaCliente;

import javax.persistence.NoResultException;
import java.util.List;

public class AdicionalDAO extends GenericDAO<Adicional>{
    @Override
    public Adicional buscarPorId(Long id) {
        try {
            String instrucaoSQL = "SELECT a FROM Adicional a " +
                    "JOIN FETCH a.itempedido " +
                    "WHERE a.id = :id";
            return EntityManager.getEM()
                    .createQuery(instrucaoSQL, Adicional.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar Adicional por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Adicional> buscarTodos() {
        String instrucaoSQL = "SELECT a FROM Adicional a";
        return EntityManager.getEM().createQuery(instrucaoSQL, Adicional.class).getResultList();
    }

    @Override
    public List<?> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT a FROM Adicional a WHERE a." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Adicional.class).getResultList();
    }
}
