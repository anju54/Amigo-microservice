package com.amigo.mailservice.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

	SimpleMailMessage constructEmail(String subject, String body,String userEmail /*, UserModel user*/);
	SimpleMailMessage registrationCredentialEmail( String token,String userEmail);
	SimpleMailMessage registrationSuccessMail(String email,String firstName);
}
