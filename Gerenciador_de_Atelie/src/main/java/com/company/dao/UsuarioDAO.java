package com.company.dao;

import com.company.Controller.UsuarioController;
import com.company.model.Identificavel;
import com.company.model.Usuario;
import com.company.model.Util.CriptografiaDeSenha;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsuarioDAO extends GenericDAO<Usuario>{
    @Override
    public void inserir(Usuario usuario){

        usuario.setSenhaUsuario(CriptografiaDeSenha.encriptaSenha(usuario.getSenhaUsuario()));
        try {
            EntityManager.getEM().getTransaction().begin();
            EntityManager.getEM().persist(usuario);
            EntityManager.getEM().getTransaction().commit();
        } catch (Exception e) {
            EntityManager.getEM().getTransaction().rollback();
            throw new RuntimeException("Erro ao inserir a entidade: " + e.getMessage(), e);
        }
    }
    @Override
    public Usuario buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(Usuario.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Usuario> buscarTodos() {
        String instrucaoSQL = "SELECT t FROM Usuario t";
        return EntityManager.getEM().createQuery(instrucaoSQL, Usuario.class).getResultList();    }


    @Override
    public List<Usuario> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT t FROM Usuario t WHERE t." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, Usuario.class).getResultList();

    }

    public Usuario retornarUsuarioPorEmailESenha(String email, String senha) {
        TypedQuery<Usuario> instrucaoSQL = EntityManager.getEM().createQuery(
                "SELECT u FROM Usuario u WHERE u.emailUsuario = :email AND u.senhaUsuario = :senha",
                Usuario.class);
        instrucaoSQL.setParameter("email", email);
        instrucaoSQL.setParameter("senha", senha);

        try {
            return instrucaoSQL.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Usuario retornarUsuarioPorEmail(String email) {
        TypedQuery<Usuario> instrucaoSQL = EntityManager.getEM().createQuery(
                "SELECT u FROM Usuario u WHERE u.emailUsuario = :email",
                Usuario.class);
        instrucaoSQL.setParameter("email", email);

        try {
            return instrucaoSQL.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        UsuarioDAO ud =new UsuarioDAO();
        Usuario usuario = new Usuario("raissinha", "emailok", "senha");
        //ud.inserir(usuario);

        UsuarioController uc = new UsuarioController();

        System.out.println(uc.verificarCredenciais("emailok", "senha"));
    }
}
