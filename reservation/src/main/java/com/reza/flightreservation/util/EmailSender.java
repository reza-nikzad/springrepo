package com.reza.flightreservation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailSender {
    @Value("${com.reza.flightreservation.util.emailsender.email.subject}")
    private String EMAIL_SUBJECT;

    @Autowired
    private JavaMailSenderImpl sender;

    public void sendEmail(String toAddress, String filePath){
        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(toAddress);
            helper.setSubject(EMAIL_SUBJECT);
            helper.setText("The Confirmation of Your Flight Reservation is Attached to the Mail.");
            helper.addAttachment("confirmation letter", new File(filePath));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);
    }
}
