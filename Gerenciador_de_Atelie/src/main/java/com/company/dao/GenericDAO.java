package com.company.dao;

import com.company.model.Tecido;

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

    public void atualizar(T entidade) {
        try {
            EntityManager.getEM().getTransaction().begin(); // Inicia a transação
            EntityManager.getEM().merge(entidade); // Realiza a operação de atualização
            EntityManager.getEM().getTransaction().commit(); // Confirma a transação
        } catch (Exception e) {
            EntityManager.getEM().getTransaction().rollback(); // Rollback da transação em caso de exceção
            throw new RuntimeException("Erro ao atualizar a entidade: " + e.getMessage(), e);
        }
    }

    <T extends Identificavel> void deletar(T entidade){
        try {
            EntityManager.getEM().getTransaction().begin(); // Inicia a transação

            if (!EntityManager.getEM().contains(entidade)) {
                // Se a entidade não estiver gerenciada, carrega-a do banco de dados
                entidade = (T) EntityManager.getEM().find(entidade.getClass(), entidade.getId());
            }

            EntityManager.getEM().remove(entidade); // Realiza a operação de inserção
            EntityManager.getEM().getTransaction().commit(); // Confirma a transação
        } catch (Exception e) {
            EntityManager.getEM().getTransaction().rollback(); // Rollback da transação em caso de exceção
            throw new RuntimeException("Erro ao deletar a entidade: " + e.getMessage(), e);
        }
    }

   public abstract T buscarPorId(Long id);

    public abstract List<T> buscarTodos();
    public abstract List<?> buscarTodosComFiltro(String atributo, String valor);
}
