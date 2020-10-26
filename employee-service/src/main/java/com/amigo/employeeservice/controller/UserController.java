package com.amigo.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigo.employeeservice.dto.RegistrationDTO;
import com.amigo.employeeservice.entities.User;
import com.amigo.employeeservice.exception.EntityNotFound;
import com.amigo.employeeservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/registration")
	public User registration(@RequestBody RegistrationDTO registrationDTO){

		return userService.saveUser(registrationDTO);
	}
	
	@GetMapping("/{id}")
	public User findUserByUserId(@PathVariable("id") int id) throws EntityNotFound {
		return userService.getEmployeeById(id);
	}
	

}
