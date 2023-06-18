package com.company.Controller;

import com.company.dao.EntityManager;
import com.company.dao.GenericDAO;
import com.company.model.Identificavel;

public abstract class GenericController<T extends Identificavel>{

    protected abstract GenericDAO<T> getDAO();

    public void inserirOuEditar(T entidade){
        GenericDAO<T> dao = getDAO();
        if (entidade.getId() == -1l) {
            dao.inserir(entidade);
        } else {
            T entidadeExistente = dao.buscarPorId(entidade.getId());
            if (entidadeExistente != null) {
                dao.atualizar(entidadeExistente);
            } else {
                throw new RuntimeException("Entidade não encontrada para atualização");
            }
        }
    }


}
