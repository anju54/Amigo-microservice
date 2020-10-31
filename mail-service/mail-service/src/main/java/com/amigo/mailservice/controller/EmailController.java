package com.amigo.mailservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	private static final Logger logger = LogManager.getLogger(EmailController.class);
	
	@RabbitListener(queues = MessagingConstants.QUEUE)
	public void consumeMsg(Response res) {
		
		System.out.print("Msged consumed"+res);
		System.out.println(res.isFlag());
		if(res.isFlag())
			registrationSuccessMail("anju.k302@gmail.com","Anju");
	}
	
	private void registrationSuccessMail(String email,String firstName) {
		
		logger.info("Sending registration successful email...");
		
		mailSender.send(emailService.registrationSuccessMail(email, firstName));
	}
}
