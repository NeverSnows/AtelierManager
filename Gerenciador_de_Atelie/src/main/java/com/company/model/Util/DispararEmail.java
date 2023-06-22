package com.company.model.Util;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class DispararEmail {
    private static final String remetente = "ateliedecosturapontocerto@outlook.com";
    private static final String senha = "SenhaAtelie4567";


    public static void enviarEmail(String destinatario, String assunto, String mensagem) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp-mail.outlook.com");
            props.put("mail.smtp.port", 587);

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(remetente, senha);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto);
            message.setText(mensagem);

            Transport.send(message);

            System.out.println("Email enviado com sucesso!");
        } catch (MessagingException e) {
            System.out.println("Erro ao enviar o email: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DispararEmail emailSender = new DispararEmail();
        String destinatario = "gjhgt67uhgty67om@cu.cu";
        String assunto = "oii";
        String mensagem = "te amo mucho";

        emailSender.enviarEmail(destinatario, assunto, mensagem);    }
}


