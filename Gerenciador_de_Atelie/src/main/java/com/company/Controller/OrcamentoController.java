package com.company.Controller;

import com.company.dao.OrcamentoDAO;
import com.company.model.Estimate;

import java.util.List;

public class OrcamentoController {

    private static OrcamentoDAO od = new OrcamentoDAO();

    public static List<Estimate> retornaOrcamentos(){
        return od.buscarTodos();
    }
}
