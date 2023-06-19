package com.company.Controller;

import com.company.dao.CodigosVerificacaoDAO;
import com.company.dao.EntityManager;
import com.company.dao.UsuarioDAO;
import com.company.model.Usuario;
import com.company.model.Util.CodigosVerificacao;
import com.company.model.Util.CriptografiaDeSenha;
import com.company.model.Util.DispararEmail;

import javax.persistence.TypedQuery;

public class UsuarioController {
    UsuarioDAO ud = new UsuarioDAO();
    public boolean verificarCredenciais(String email, String senha) {
        String senhaCriptografada = CriptografiaDeSenha.encriptaSenha(senha);
        Usuario usuario = ud.retornarUsuarioPorEmailESenha(email, senhaCriptografada);

        if (usuario != null && usuario.getEmailUsuario().equals(email) && usuario.getSenhaUsuario().equals(senhaCriptografada)) {
            return true;
        } else {
            System.out.println("Não foi possível fazer a validação");
            return false;
        }
    }

    public boolean validaEmail(String email){
        Usuario usuario = ud.retornarUsuarioPorEmail(email);
        try{
            return usuario.getEmailUsuario().equals(email);
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
            Usuario usuario = new Usuario(nomeUsuario, emailUsuario, senha);
            ud.inserir(usuario);
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
        //uc.cadastraNovoUsuario("raissa", "raissalagess@gmail.com", "senhaa");

        //uc.enviaCodigoVerificacao("raissalagess@gmail.com");
        if(cvd.validaCodigoVerificacao("86820067"))
            uc.alterarSenha("raissalagess@gmail.com", "afgrhgbaa");


    }
}

