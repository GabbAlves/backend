package com.GOATstore.backend.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;




@Service
public class EmailService {
    
   @Autowired
   private JavaMailSender javaMailSender;

   public String enviarEmailTexto(String destinatario, String titulo, String menssagem) {
		
    try {
        
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("fabricinho547@gmail.com");
        simpleMailMessage.setTo(destinatario);
        simpleMailMessage.setSubject(titulo);
        simpleMailMessage.setText(menssagem);
        javaMailSender.send(simpleMailMessage);
        return "Email enviado";
    } catch(Exception ex ) {
        return "erro ao enviar o email";
    }
}
}
