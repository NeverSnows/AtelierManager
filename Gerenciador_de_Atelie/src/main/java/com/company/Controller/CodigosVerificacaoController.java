package com.company.Controller;

import com.company.dao.CodigosVerificacaoDAO;
import com.company.model.Util.CodigosVerificacao;

public class CodigosVerificacaoController {
    private static CodigosVerificacaoDAO cvd = new CodigosVerificacaoDAO();

    public CodigosVerificacao criarCodigoVerificacao(String email){
        CodigosVerificacao codigo = cvd.buscaCodigoPorEmail(email);
        cvd.inserir(codigo);

        return codigo;
    }

    public static boolean validaCodigoVerificacao(String email, String codigo){
        if(cvd.buscaCodigo(codigo) != null)
            return true;
        return false;
    }



    public static void main(String[] args) {
        CodigosVerificacaoDAO cvd = new CodigosVerificacaoDAO();

        System.out.println(cvd.buscaCodigo("232"));
    }
}
