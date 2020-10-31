package com.amigo.employeeservice.serviceImpl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigo.employeeservice.dto.RegistrationDTO;
import com.amigo.employeeservice.entities.User;
import com.amigo.employeeservice.exception.EntityAlreadyExists;
import com.amigo.employeeservice.exception.EntityNotFound;
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
	
	/**
	 * Method for getting user by user id
	 */
	@Override
	public User getEmployeeById(int id) throws EntityNotFound {
		
		Optional<User> opUser = userRepository.findById(id);
		User user = opUser.get();
		if(!opUser.isPresent()) {
			throw new EntityNotFound("User not found");
		}
		return user;
	}

	/**
	 * Method for getting the recent inserted user id
	 * @return recent id
	 */
	@Override
	public int getLastUserId() {
		User user = userRepository.findTopByOrderByIdDesc();
		int id = 0;
		if(user!=null)
			id = user.getId();
		return id;
	}

	/**
	 * Method for saving user 
	 * @throws EntityAlreadyExists 
	 */
	@Override
	public User saveUser(RegistrationDTO registrationDTO) throws EntityAlreadyExists {
		
		logger.info("User saving request has started...");
		
		User existingUser = checkForDuplicateUser(registrationDTO.getEmail());
		
		if(existingUser==null) {
			User user = registrationToEmployeeModelMapper(registrationDTO);
			String employeeCode = employeeCodeGenerator.getNextEmployeeCode();
			user.setEmployeeCode(employeeCode);
			
			String fullName = registrationDTO.getFirstName()+ " " + registrationDTO.getMiddleName()+" " + registrationDTO.getLastName();
			user.setFullName(fullName);
			
			return userRepository.save(user);
		}
		return null;
	}
	
	private User checkForDuplicateUser(String email) throws EntityAlreadyExists {
		
		User existingUser = userRepository.findByEmail(email);
		
		if(existingUser!=null)
			throw new EntityAlreadyExists("User with this email " +email+ " already exists!");
		
		return existingUser;
	}
	
	/**
	 * DTO to modal Mapper
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
