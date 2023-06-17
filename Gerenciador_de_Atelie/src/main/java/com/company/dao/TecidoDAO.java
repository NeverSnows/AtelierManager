package com.company.dao;

import com.company.model.Tecido;

import javax.persistence.TypedQuery;
import java.util.List;

public class TecidoDAO extends GenericDAO<Tecido>{
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
    public List<TecidoDTO> buscarTodosComFiltro(String atributo, String valor) {
        String instrucaoSQL = "SELECT new com.company.dao.TecidoDTO(t.nome, t.preco) FROM Tecido t WHERE t." + atributo +
                " like '%" + valor + "%'";
        return EntityManager.getEM().createQuery(instrucaoSQL, TecidoDTO.class).getResultList();
    }


    public static void main(String[] args) {
        TecidoDAO t = new TecidoDAO();
                Tecido tec = new Tecido("couro", 500.00);
        t.inserir(tec);

        t.deletar(tec);
    }
}
