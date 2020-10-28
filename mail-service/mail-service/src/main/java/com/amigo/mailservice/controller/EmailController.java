package com.amigo.mailservice.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RestController;

import com.amigo.mailservice.constants.MessagingConstants;
import com.amigo.mailservice.dto.Response;
import com.amigo.mailservice.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RabbitListener(queues = MessagingConstants.QUEUE)
	public void consumeMsg(Response res) {
		System.out.print("Msged consume"+res);
		registrationSuccessMail("anju.k302@gmail.com","Anju");
	}
	
	private void registrationSuccessMail(String email,String firstName) {
		
		System.out.print("callling ");
		
		mailSender.send(emailService.registrationSuccessMail(email, firstName));
	}
}
