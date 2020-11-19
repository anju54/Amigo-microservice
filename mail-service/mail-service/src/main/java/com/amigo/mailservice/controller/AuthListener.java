package com.amigo.mailservice.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amigo.mailservice.constants.MessagingConstants;
import com.amigo.mailservice.dto.UserCredential;
import com.amigo.mailservice.service.EmailService;

@Component
public class AuthListener {

	@Autowired
	private EmailService emailService;
	
	@RabbitListener(queues = MessagingConstants.SETPASSWORD_QUEUE)
	public void listenToSetPasswordQueue(UserCredential res) {
		
		emailService.passwordResetSuccefullEmail(res.getEmail());
		//return res;
	}
	
	
}
