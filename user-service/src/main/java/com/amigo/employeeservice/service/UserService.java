package com.amigo.employeeservice.service;

import java.util.List;

import com.amigo.employeeservice.dto.RegistrationDTO;
import com.amigo.employeeservice.dto.UserMessage;
import com.amigo.employeeservice.entities.User;
import com.amigo.employeeservice.exception.EntityAlreadyExists;
import com.amigo.employeeservice.exception.EntityNotFound;

public interface UserService {

	int getLastUserId();
	UserMessage saveUser(RegistrationDTO registrationDTO) throws EntityAlreadyExists;
	
	/**
	 * Method for getting user by user id
	 */
	User getUserById(int id) throws EntityNotFound;
	List<User> getAllUser();
}
