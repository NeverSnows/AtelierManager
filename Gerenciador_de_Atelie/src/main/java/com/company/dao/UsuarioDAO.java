package com.company.dao;

import com.company.model.Usuario;

import java.util.List;

public class UsuarioDAO extends GenericDAO<Usuario>{

    @Override
    public Usuario buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Usuario> buscarTodos() {
        return null;
    }

    @Override
    public List<Usuario> buscarTodosComFiltro(String atributo, String valor) {
        return null;
    }
}
