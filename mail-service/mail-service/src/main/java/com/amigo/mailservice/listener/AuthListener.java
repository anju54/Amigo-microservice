package com.amigo.mailservice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final static Logger logger = LoggerFactory.getLogger(AuthListener.class);
	
	@RabbitListener(queues = MessagingConstants.SETPASSWORD_QUEUE)
	public void listenToSetPasswordQueue(UserCredential res) {
		
		logger.info("Message receved from set-password-queue");
		
		emailService.passwordResetSuccefullEmail(res.getEmail());
		//return res;
	}
	
	
}
