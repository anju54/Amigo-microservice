package com.amigo.employeeservice.service;

import com.amigo.employeeservice.dto.RegistrationDTO;
import com.amigo.employeeservice.entities.User;
import com.amigo.employeeservice.exception.EntityNotFound;

public interface UserService {

	User getEmployeeById(int id) throws EntityNotFound;
	int getLastUserId();
	User saveUser(RegistrationDTO registrationDTO);
}
