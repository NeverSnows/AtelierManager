package com.company.dao;

import com.company.Controller.TecidoController;
import com.company.model.Identificavel;
import com.company.model.Tecido;
import com.company.model.Usuario;

import javax.persistence.TypedQuery;
import java.util.List;

public class TecidoDAO extends GenericDAO<Tecido>{


/*
    public void atualizar(Tecido tecido) {
        try {
            EntityManager.getEM().getTransaction().begin();
            Tecido entidadeExistente = EntityManager.getEM().find(tecido.getClass(), tecido.getId());
            if (entidadeExistente != null) {
                // Copiar os valores da entidade passada como argumento para a entidade existente
                entidadeExistente.setNome(tecido.getNome());
                entidadeExistente.setPreco(tecido.getPreco());
                // Copie os outros atributos da entidade conforme necessário

                EntityManager.getEM().merge(entidadeExistente);
            } else {
                throw new RuntimeException("Entidade não encontrada para atualização");
            }

            EntityManager.getEM().getTransaction().commit();

        } catch (Exception e) {
            EntityManager.getEM().getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar a entidade: " + e.getMessage(), e);
        }
    }
*/

    @Override
    public Tecido buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Tecido.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }
    }
    @Override
    public List<Tecido> buscarTodos() {
        String instrucaoSQL = "SELECT t FROM Tecido t";
        return EntityManager.getEM().createQuery(instrucaoSQL, Tecido.class).getResultList();
    }

    @Override
    public List<Tecido> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT t FROM Tecido t WHERE t." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Tecido.class).getResultList();
    }


    public static void main(String[] args) {
        TecidoDAO t = new TecidoDAO();
        TecidoController tc = new TecidoController();
                Tecido tec = new Tecido(4l,"cooouro", 5000.00);

                t.atualizar(tec);
                t.deletar(tec);
        System.out.println(t.buscarTodosComFiltro("preco", "50"));


    }
}
