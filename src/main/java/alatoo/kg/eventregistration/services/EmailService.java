package alatoo.kg.eventregistration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendConfirmationEmail(String to, String token) {
        String subject = "Event Registration Confirmation";
        String confirmationUrl = "http://localhost:8080/api/participants/confirm?token=" + token;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText("Please confirm your registration by clicking the link: " + confirmationUrl);

        emailSender.send(message);
    }
}
