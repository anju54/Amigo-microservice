package com.amigo.employeeservice.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigo.employeeservice.dto.RegistrationDTO;
import com.amigo.employeeservice.entities.User;
import com.amigo.employeeservice.repository.UserRepository;
import com.amigo.employeeservice.service.UserService;
import com.amigo.employeeservice.util.EmployeeCodeGenerator;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	public EmployeeCodeGenerator employeeCodeGenerator;
	
	@Override
	public void getEmployeeById(Long id) {
		
		
	}

	/**
	 * Method for getting the recent inserted user id
	 * @return recent id
	 */
	@Override
	public int getLastUserId() {
		User user = userRepository.findTopByOrderByIdDesc();
		int id = user.getId();
		return id;
	}

	@Override
	public User saveUser(RegistrationDTO registrationDTO) {
		
		User user = registrationToEmployeeModelMapper(registrationDTO);
		String employeeCode = employeeCodeGenerator.getNextEmployeeCode();
		user.setEmployeeCode(employeeCode);
		
		return userRepository.save(user);
	}
	
	/**
	 * Dto to modal mapper
	 * @param registrationDTO
	 * @param user
	 * @return
	 */
	private User registrationToEmployeeModelMapper(RegistrationDTO registrationDTO) {
		
		User user = new User();
		user.setFirstName(registrationDTO.getFirstName());
		user.setMiddleName(registrationDTO.getMiddleName());
		user.setEmail(registrationDTO.getEmail());
		user.setGender(registrationDTO.getGender());
		user.setPassword(registrationDTO.getPassword());
		user.setMobileNumber(registrationDTO.getMobileNumber());
		
		return user;
	}
	
	
}
