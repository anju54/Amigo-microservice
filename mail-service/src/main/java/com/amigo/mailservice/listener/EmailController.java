package com.amigo.mailservice.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RestController;

import com.amigo.mailservice.constants.MessagingConstants;
import com.amigo.mailservice.dto.UserMessage;
import com.amigo.mailservice.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger = LogManager.getLogger(EmailController.class);
	
	@RabbitListener(queues = MessagingConstants.REGISTRATION_QUEUE)
	public void consumeMsg(UserMessage res) {
		
		System.out.print("Msged consumed....");
		
		registrationSuccessMail(res.getEmailId(),res.getFirstName(),res.getResetToken(),res.getUserId());
		//return res;
	}
	
	private void registrationSuccessMail(String email,String firstName,String token,int userId) {
		
		logger.info("Sending registration successful email...");
		
		mailSender.send(emailService.registrationSuccessMail(email, firstName,token,userId));
	}
}
