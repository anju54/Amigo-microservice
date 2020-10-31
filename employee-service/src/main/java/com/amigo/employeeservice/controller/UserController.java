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
import com.amigo.employeeservice.dto.Response;
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
	public User registration(@RequestBody RegistrationDTO registrationDTO) throws EntityAlreadyExists{
		
		Response response = new Response();
		
		response.setMessage("User successfully registered!!");
		response.setFlag(true);

		template.convertAndSend(MessagingConstants.EXCHANGE,MessagingConstants.ROUTING_KEY,response);
		return userService.saveUser(registrationDTO);
	}
	
	@GetMapping("/{id}")
	public User findUserByUserId(@PathVariable("id") int id) throws EntityNotFound {
		
		User user = userService.getEmployeeById(id);
		System.out.println(user.getFullName());
		template.convertAndSend(MessagingConstants.EXCHANGE,MessagingConstants.ROUTING_KEY,user);
		return user;
	}
	

}
