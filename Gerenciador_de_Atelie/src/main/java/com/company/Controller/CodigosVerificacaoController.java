package com.company.Controller;

import com.company.dao.CodigosVerificacaoDAO;
import com.company.model.Util.CodigosVerificacao;

public class CodigosVerificacaoController {
    CodigosVerificacaoDAO cvd = new CodigosVerificacaoDAO();

    public CodigosVerificacao criarCodigoVerificacao(String email){
        CodigosVerificacao cv = new CodigosVerificacao(email);
        cvd.inserir(cv);

        return cv;
    }

    public boolean validaCodigoVerificacao(String codigo){
        if(cvd.buscaCodigo(codigo) != null)
            return true;
        return false;
    }



    public static void main(String[] args) {
        CodigosVerificacaoDAO cvd = new CodigosVerificacaoDAO();

        System.out.println(cvd.buscaCodigo("232"));
    }
}
