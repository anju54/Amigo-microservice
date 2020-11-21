package com.amigo.employeeservice.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigo.employeeservice.constants.MessagingConstants;
import com.amigo.employeeservice.dto.RegistrationDTO;
import com.amigo.employeeservice.dto.UserMessage;
import com.amigo.employeeservice.entities.User;
import com.amigo.employeeservice.exception.EntityAlreadyExists;
import com.amigo.employeeservice.exception.EntityNotFound;
import com.amigo.employeeservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RabbitTemplate template;

	@PostMapping(value = "/registration")
	public UserMessage registration(@RequestBody RegistrationDTO registrationDTO) throws EntityAlreadyExists{

		UserMessage userMessage = new UserMessage();
		userMessage = userService.saveUser(registrationDTO);
		
		// Send confirmation to rabbit mq to send email to user
		template.convertAndSend(MessagingConstants.EXCHANGE,MessagingConstants.ROUTING_KEY,userMessage);
		
		return userMessage;
	}
	
	@GetMapping("/{id}")
	public User findUserByUserId(@PathVariable("id") int id) throws EntityNotFound {
		
		User user = userService.getEmployeeById(id);
		//template.convertAndSend(MessagingConstants.EXCHANGE,MessagingConstants.ROUTING_KEY,user);
		return user;
	}
	

}
