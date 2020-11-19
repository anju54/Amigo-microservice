package com.amigo.authserver.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigo.authserver.entities.User;
import com.amigo.authserver.service.AuthService;
import com.amigo.authserver.constants.MessagingConstants;

@RestController
@RequestMapping("/auth-server")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/set-password/")
	public void setPassword(@RequestBody User user) {
		
		authService.setPassword(user);
		
		template.convertAndSend(MessagingConstants.EXCHANGE,MessagingConstants.SET_PASSWORD_KEY,user);
	}

}
