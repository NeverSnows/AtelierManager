package com.company.model.Util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaDeSenha {
    public static String encriptaSenha(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashCodificado = md.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder stringHexadecimal = new StringBuilder();
            for (byte b : hashCodificado) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    stringHexadecimal.append('0');
                stringHexadecimal.append(hex);
            }

            return stringHexadecimal.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static void main(String[] args) {
        String password = "senha123";
        String encryptedPassword = encriptaSenha(password);
        System.out.println("Senha criptografada: " + encryptedPassword);

    }
}
