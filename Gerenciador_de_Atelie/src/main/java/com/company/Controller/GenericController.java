package com.company.Controller;

import com.company.dao.EntityManager;
import com.company.dao.GenericDAO;
import com.company.model.Identificavel;

public abstract class GenericController<T extends Identificavel>{

    protected abstract GenericDAO<T> getDAO();


    public void inserirOuEditar(T entidade){

        if (entidade.getId() == -1l) {
            EntityManager.getEM().merge(entidade);
            getDAO().inserir(entidade);
        } else {
            T entidadeExistente = getDAO().buscarPorId(entidade.getId());
            if (entidadeExistente != null) {
                getDAO().atualizar(entidadeExistente);
            } else {
                throw new RuntimeException("Entidade não encontrada para atualização");
            }
        }
    }


}
