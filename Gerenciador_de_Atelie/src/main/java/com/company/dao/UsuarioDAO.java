package com.company.dao;

import com.company.Controller.UsuarioController;
import com.company.model.User;
import com.company.model.Util.CriptografiaDeSenha;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsuarioDAO extends GenericDAO<User>{
    public static boolean inserirr(User user){

        user.setSenhaUsuario(CriptografiaDeSenha.encriptaSenha(user.getSenhaUsuario()));
        try {
            EntityManager.getEM().getTransaction().begin();
            EntityManager.getEM().persist(user);
            EntityManager.getEM().getTransaction().commit();
            return true;
        } catch (Exception e) {
            EntityManager.getEM().getTransaction().rollback();
            throw new RuntimeException("Erro ao inserir a entidade: " + e.getMessage(), e);

        }
    }
    @Override
    public User buscarPorId(Long id) {
        try {
            return EntityManager.getEM().find(User.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar entidade por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<User> buscarTodos() {
        String instrucaoSQL = "SELECT t FROM User t";
        return EntityManager.getEM().createQuery(instrucaoSQL, User.class).getResultList();    }


    @Override
    public List<User> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT t FROM User t WHERE t." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, User.class).getResultList();

    }

    public static User retornarUsuarioPorEmailESenha(String email, String senha) {
        TypedQuery<User> instrucaoSQL = EntityManager.getEM().createQuery(
                "SELECT u FROM User u WHERE u.emailUsuario = :email AND u.senhaUsuario = :senha",
                User.class);
        instrucaoSQL.setParameter("email", email);
        instrucaoSQL.setParameter("senha", senha);

        try {
            return instrucaoSQL.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public static boolean retornarUsuarioPorEmailESenhaBool(String email, String senha) {
        TypedQuery<User> instrucaoSQL = EntityManager.getEM().createQuery(
                "SELECT u FROM User u WHERE u.emailUsuario = :email AND u.senhaUsuario = :senha",
                User.class);
        instrucaoSQL.setParameter("email", email);
        instrucaoSQL.setParameter("senha", senha);


        try {
            instrucaoSQL.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    public static User retornarUsuarioPorEmail(String email) {
        TypedQuery<User> instrucaoSQL = EntityManager.getEM().createQuery(
                "SELECT u FROM User u WHERE u.emailUsuario = :email",
                User.class);
        instrucaoSQL.setParameter("email", email);

        try {
            return instrucaoSQL.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void atualizarSenha(String email, String novaSenha) {
        String senhaCriptografada = CriptografiaDeSenha.encriptaSenha(novaSenha);

        EntityManager.getEM().getTransaction().begin();
        Query query = EntityManager.getEM().createNativeQuery("UPDATE User SET senhaUsuario = :senha WHERE emailUsuario = :email");
        query.setParameter("senha", senhaCriptografada);
        query.setParameter("email", email);
        query.executeUpdate();
        EntityManager.getEM().getTransaction().commit();
    }


    public static void main(String[] args) {
        UsuarioDAO ud =new UsuarioDAO();
        User user = new User("raissinha", "emailok", "senha");
        ud.inserir(user);

        UsuarioController uc = new UsuarioController();

        System.out.println(uc.verificarCredenciais("emailok", "senha"));
    }
}
