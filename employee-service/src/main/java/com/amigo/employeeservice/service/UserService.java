package com.amigo.employeeservice.service;

import com.amigo.employeeservice.dto.RegistrationDTO;
import com.amigo.employeeservice.entities.User;

public interface UserService {

	void getEmployeeById(Long id);
	int getLastUserId();
	User saveUser(RegistrationDTO registrationDTO);
}
