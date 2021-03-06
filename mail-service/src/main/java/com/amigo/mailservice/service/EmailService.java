package com.amigo.mailservice.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

	SimpleMailMessage constructEmail(String subject, String body,String userEmail /*, UserModel user*/);
	SimpleMailMessage registrationSuccessMail(String email,String firstName,String token,int userId);
	
	SimpleMailMessage passwordResetSuccefullEmail(String userEmail);
}
