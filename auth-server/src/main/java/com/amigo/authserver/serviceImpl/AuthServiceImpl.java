package com.amigo.authserver.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigo.authserver.dto.UserMessage;
import com.amigo.authserver.entities.User;
import com.amigo.authserver.service.AuthService;
import com.amigo.authserver.service.UserService;

@Service
public class AuthServiceImpl implements AuthService {
	
	private final static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	
	@Autowired
	private UserService userService;

	@Override
	public void setPassword(User user) {
		
		logger.info("Setting password for the first time ...");
		
		userService.saveUserLoginDetail(user);
	}
	
	/**
	 * This method is used to validate the token
	 * 
	 * @param id
	 * 			user id
	 * @param token
	 * 			token
	 * @return true ( if all the condition passed ).
	 */
	public boolean validatePasswordResetToken(int userId, String token) {
		
		// check expiry of token
		return false;
		
	}

}
