package com.amigo.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigo.employeeservice.dto.RegistrationDTO;
import com.amigo.employeeservice.entities.User;
import com.amigo.employeeservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userDao;

	@PostMapping(value = "/registration")
	public User registration(@RequestBody RegistrationDTO registrationDTO){

		return userDao.saveUser(registrationDTO);
	}
	

}
