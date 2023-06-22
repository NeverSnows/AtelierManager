package com.company.dao;

import com.company.model.Identificavel;

import java.util.List;

public abstract class GenericDAO<T> {

    protected void fecharConexao(){
        EntityManager.getEMF().close();
    }
    public void inserir(T entidade){

        try {
            EntityManager.getEM().getTransaction().begin();
            EntityManager.getEM().persist(entidade);
            EntityManager.getEM().getTransaction().commit();
        } catch (Exception e) {
            EntityManager.getEM().getTransaction().rollback();
            throw new RuntimeException("Erro ao inserir a entidade: " + e.getMessage(), e);
        }
    }

    public <Object extends Identificavel> void atualizar(Object entidade) {
        try {
            EntityManager.getEM().getTransaction().begin();
            EntityManager.getEM().merge(entidade);
            EntityManager.getEM().getTransaction().commit();
        } catch (Exception e) {
            EntityManager.getEM().getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar a entidade: " + e.getMessage(), e);
        }
    }

    public <T extends Identificavel> void deletar(T entidade){
        try {
            EntityManager.getEM().getTransaction().begin();
            T entidadee = entidade;
            if (!EntityManager.getEM().contains(entidade)) {
                entidadee = (T) EntityManager.getEM().find(entidade.getClass(), entidade.getId());
            }
            EntityManager.getEM().remove(entidadee);
            EntityManager.getEM().getTransaction().commit();
        } catch (Exception e) {
            EntityManager.getEM().getTransaction().rollback();
            throw new RuntimeException("Erro ao deletar a entidade: " + e.getMessage(), e);
        }
    }


    public abstract T buscarPorId(Long id);

    public abstract List<T> buscarTodos();
    public abstract List<?> buscarTodosComFiltro(String atributo, String valor);


}
