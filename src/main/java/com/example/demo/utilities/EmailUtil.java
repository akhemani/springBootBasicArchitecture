package com.example.demo.utilities;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	
	public static void sendEmail (Message message) {
	    
	    try {
			Transport.send(message);
			System.out.println("SimpleEmail Sent");
		} catch (MessagingException e) {
			e.printStackTrace();
		}	    
	    
	}
	
	public static void configureEmail (String to, String subject, String mailMessage) {
		System.out.println("SimpleEmail Start");
		
	    String smtpHostServer = "smtp.gmail.com";
	    String smtpMailPort = "587";
	    String smtpMailAuth = "true";
	    String smtpMailStarttls = "true";
	    
	    String email = "ameetkhemani.ongraph@gmail.com";
	    String password = "ongraph123";
	    
	    String fromMail = "ameetkhemani.ongraph@gmail.com";
	    String toMail = to;
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);
	    props.put("mail.smtp.port", smtpMailPort);
	    props.put("mail.smtp.auth", smtpMailAuth);
	    props.put("mail.smtp.starttls.enable", smtpMailStarttls);

	    Session session = Session.getInstance(props, new Authenticator() {
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication(email, password);
	    	}
		});
	    
	    Message message = new MimeMessage(session);
	    try {
			message.setFrom(new InternetAddress(fromMail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			message.setSubject(subject);
			message.setText(mailMessage);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	    
	    sendEmail(message);
	}
}
