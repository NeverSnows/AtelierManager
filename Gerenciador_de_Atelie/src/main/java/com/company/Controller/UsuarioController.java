package com.company.Controller;

import com.company.dao.UsuarioDAO;
import com.company.model.Usuario;
import com.company.model.Util.CriptografiaDeSenha;

import java.util.List;

public class UsuarioController {

    public boolean verificarCredenciais(String email, String senha) {
        UsuarioDAO ud = new UsuarioDAO();
        String senhaCriptografada = CriptografiaDeSenha.encriptaSenha(senha);
        Usuario usuario = ud.retornarEmailESenha(email, senhaCriptografada);

        if (usuario != null && usuario.getEmailUsuario().equals(email) && usuario.getSenhaUsuario().equals(senhaCriptografada)) {
            return true;
        } else {
            System.out.println("Não foi possível fazer a validação");
            return false;
        }
    }

    public static void main(String[] args) {
        UsuarioController uc = new UsuarioController();
        System.out.println(uc.verificarCredenciais("emmaiol", "senha"));
    }
}

