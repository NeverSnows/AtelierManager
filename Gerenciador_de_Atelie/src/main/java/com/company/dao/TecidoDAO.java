package com.company.dao;

import com.company.Controller.TecidoController;
import com.company.model.Fabric;

import java.util.List;

public class TecidoDAO extends GenericDAO<Fabric>{

    @Override
    public Fabric buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Fabric.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }
    }
    @Override
    public List<Fabric> buscarTodos() {
        String instrucaoSQL = "SELECT t FROM Fabric t";
        return EntityManager.getEM().createQuery(instrucaoSQL, Fabric.class).getResultList();
    }

    @Override
    public List<Fabric> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT t FROM Fabric t WHERE t." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Fabric.class).getResultList();
    }


    public static void main(String[] args) {
        TecidoDAO t = new TecidoDAO();
        TecidoController tc = new TecidoController();
                Fabric tec = new Fabric(-2l,"cooouro", 5000.00);

                t.atualizar(tec);

        System.out.println(t.buscarTodosComFiltro("preco", "50"));


    }
}
