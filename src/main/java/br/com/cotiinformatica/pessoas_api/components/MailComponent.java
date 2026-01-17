package br.com.cotiinformatica.pessoas_api.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailComponent {

    @Autowired
    private JavaMailSender javaMailSender;

    /*
        Método para realizar os disparos de email
     */
    public void sendMail(String to, String subject, String body) throws Exception {

        //Configurando o conteudo da mensagem
        var message = javaMailSender.createMimeMessage();
        var helper = new MimeMessageHelper(message, true, "UTF-8");

        //Montando o email
        helper.setFrom("naoresponda@cotiinformatica.com.br");
        helper.setTo(to); //Destinatário do email
        helper.setSubject(subject); //Assunto do email
        helper.setText(body, true); //Corpo do email

        //Enviando o email
        javaMailSender.send(message);
    }
}
