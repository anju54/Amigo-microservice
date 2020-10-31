package com.amigo.mailservice.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.amigo.mailservice.service.EmailService;

/**
 * This service class is used to send mail with token 
 * @author anjuk
 *
 */
@Component
public class EmailServiceImpl implements EmailService {
	
	private final static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	 @Autowired
	 public JavaMailSender emailSender;
	 
	 /**
	  * used to structure the email
	  * @param subject
	  * @param body
	  * @param user
	  * @return SimpleMailMessage object.
	  */
	 public SimpleMailMessage constructEmail(String subject, String body , String userEmail) {
	 
		    SimpleMailMessage email = new SimpleMailMessage();
		    email.setSubject(subject);
		    email.setText(body);
		    email.setTo(userEmail);
		    email.setFrom("anju.k302@gmail.com");
		    
		    logger.info("mail has been sent to "+userEmail);
		    return email;
	 }
	 
	 public SimpleMailMessage registrationSuccessMail(String email,String firstName) {
		 
		 String prefix = "Dear "+ firstName +"\n" +"Welcome !!" + "\n";
		 String body = "You account for amigo shopee has been created successfully!" ;
		 
		 String subject = "Confirmation email" ;
		 
		 return constructEmail(subject, prefix+body, email);
	 }

	@Override
	public SimpleMailMessage registrationCredentialEmail(String token, String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 /**
	  * used for sending the email with login detail after the user registration
	  * @param User object
	  * @param password
	  * @return link SimpleMailMessage object
	  */
//	 public SimpleMailMessage registrationCredentialEmail( String email,String token) {
//		 	
//		    String body = Const.RESET_PASSWORD_LINK +"?token="+token+"&id="+user.getId();
//		    
//		    return constructEmail("set password", "click here to set password  " + body , user);
//	 }	 	
}
