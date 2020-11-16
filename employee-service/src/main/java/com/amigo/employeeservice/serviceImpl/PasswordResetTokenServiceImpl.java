package com.amigo.employeeservice.serviceImpl;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigo.employeeservice.entities.PasswordResetToken;
import com.amigo.employeeservice.repository.PasswordResetTokenRepository;
import com.amigo.employeeservice.service.PasswordResetTokenService;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService{
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	private static final Logger logger = LogManager.getLogger(PasswordResetTokenServiceImpl.class);

	@Override
	public PasswordResetToken createToken(int userId) {

		PasswordResetToken passwordResetToken = new PasswordResetToken();
		String token = UUID.randomUUID().toString();
		passwordResetToken.setResetToken(token);
		
		logger.info("Password set token has created successfully for the user "+userId);
		
		return passwordResetTokenRepository.save(passwordResetToken);
	}

}
