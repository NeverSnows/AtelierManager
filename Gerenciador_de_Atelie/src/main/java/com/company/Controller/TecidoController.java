package com.company.Controller;

import com.company.dao.GenericDAO;
import com.company.dao.TecidoDAO;
import com.company.model.Fabric;

import java.util.List;

public class TecidoController extends GenericController<Fabric>{
    @Override
    protected GenericDAO<Fabric> getDAO() {
        return new TecidoDAO();
    }
    private static TecidoDAO td = new TecidoDAO();

    public static void insereTecido(Fabric fabric){
        td.inserir(fabric);
    }

    public static List<Fabric> retornaTecidos(){
        return td.buscarTodos();
    }

    public static void main(String[] args) {
        Fabric fabric = new Fabric(5l,"courino", 10.00);

    }

}
