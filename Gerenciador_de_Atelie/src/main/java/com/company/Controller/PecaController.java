package com.company.Controller;

import com.company.dao.PecaDAO;
import com.company.model.Piece;

import java.util.List;

public class PecaController {
    private static PecaDAO pd = new PecaDAO();

    public static void inserePeca(Piece piece){
        pd.inserir(piece);
    }

    public static List<Piece> retornaPecas(){
        return pd.buscarTodos();
    }

    public static void deletarPeca(Piece piece){
        pd.deletar(piece);
    }
}
