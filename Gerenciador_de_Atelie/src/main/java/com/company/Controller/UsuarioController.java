package com.company.Controller;

import com.company.dao.CodigosVerificacaoDAO;
import com.company.dao.UsuarioDAO;
import com.company.model.User;
import com.company.model.Util.CodigosVerificacao;
import com.company.model.Util.CriptografiaDeSenha;
import com.company.model.Util.DispararEmail;

public class UsuarioController {
    UsuarioDAO ud = new UsuarioDAO();

    public static boolean verificarCredenciais(String email, String senha) {
        String senhaCriptografada = CriptografiaDeSenha.encriptaSenha(senha);
        User user = UsuarioDAO.retornarUsuarioPorEmailESenha(email, senhaCriptografada);

        if (user != null && user.getEmailUsuario().equals(email) && user.getSenhaUsuario().equals(senhaCriptografada)) {
            return true;
        } else {
            System.out.println("Não foi possível fazer a validação");
            return false;
        }
    }

    public static boolean validaEmail(String email){
        User user = UsuarioDAO.retornarUsuarioPorEmail(email);
        try{
            return user.getEmailUsuario().equals(email);
        }
        catch (NullPointerException npe){
            System.out.println("Usuario não cadastrado");
        }
        return false;
    }

    public void enviaCodigoVerificacao(String email){
        if(validaEmail(email)){
            CodigosVerificacaoController cvc = new CodigosVerificacaoController();
            CodigosVerificacao codigo = cvc.criarCodigoVerificacao(email);


            String mensagem = "Olá!\n\n" +
                    "Você solicitou um código para recuperar a sua senha no Ateliê de Costura Ponto Certo.\n\n " +
                    "Para redefinir sua senha, utilize o código de verificação: " + codigo.getCodigo();

            DispararEmail.enviarEmail(email, "Recuperação de senha", mensagem);
        }
    }

    public void cadastraNovoUsuario(String nomeUsuario, String emailUsuario, String senha){
        if(!validaEmail(emailUsuario)){
            User user = new User(nomeUsuario, emailUsuario, senha);
            ud.inserir(user);
        }
        else{
            System.out.println("Já cadastrado");
        }
    }
    public void alterarSenha(String email, String novaSenha) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CodigosVerificacaoDAO codigoDAO = new CodigosVerificacaoDAO();

        usuarioDAO.atualizarSenha(email, novaSenha);

        codigoDAO.atualizarCodigo(email);
    }



    public static void main(String[] args) {
        UsuarioController uc = new UsuarioController();
        CodigosVerificacaoController cvd = new CodigosVerificacaoController();
        System.out.println(uc.verificarCredenciais("emmaiol", "senha"));
        System.out.println(uc.validaEmail("emailok"));
        uc.cadastraNovoUsuario("prof", "igor.sampaio@ifsp.edu.br", "senha");


       // uc.enviaCodigoVerificacao("raissalagess@gmail.com");
       if(cvd.validaCodigoVerificacao("23217312"))
            uc.alterarSenha("raissalagess@gmail.com", "afgrhgbaa");


    }
}

