package com.example.mailExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMilExmple implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendMail(MailModal payload) throws MailSendException {

		SimpleMailMessage  msg = new SimpleMailMessage();
		msg.setFrom("nhclc47@gmail.com");
		msg.setTo(payload.getTo());
		msg.setText(payload.getSubject());
		msg.setText(payload.getMessage());
		javaMailSender.send(msg);
		System.out.println("===========Mail sent successfully");
	}

	
	
}
