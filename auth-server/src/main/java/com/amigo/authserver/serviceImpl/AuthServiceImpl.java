package com.amigo.authserver.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
