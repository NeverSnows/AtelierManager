package com.company.Controller;

import com.company.dao.ModeloDAO;
import com.company.model.Model;

import java.util.List;

public class ModeloController {
    private static ModeloDAO md = new ModeloDAO();

    public static void insereModelo(Model modelo){
        md.inserir(modelo);
    }

    public static List<Model> retornaModelos(){
        return md.buscarTodos();
    }
}
