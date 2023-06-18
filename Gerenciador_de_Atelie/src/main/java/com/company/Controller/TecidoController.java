package com.company.Controller;

import com.company.dao.GenericDAO;
import com.company.dao.TecidoDAO;
import com.company.model.Identificavel;
import com.company.model.Tecido;

import java.util.ArrayList;
import java.util.List;

public class TecidoController extends GenericController<Tecido>{
    @Override
    protected GenericDAO<Tecido> getDAO() {
        return new TecidoDAO();
    }


    public static void main(String[] args) {
        Tecido tecido = new Tecido("courino", 10.00);

        TecidoController tc = new TecidoController();

        tc.inserirOuEditar(tecido);
    }

}
