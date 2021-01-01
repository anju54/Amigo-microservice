package com.amigo.authserver.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.amigo.authserver.entities.User;
import com.amigo.authserver.repository.UserRepository;
import com.amigo.authserver.service.UserService;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUserLoginDetail(User user) {
		
//		User user = new User();
//		user.setEmail(userMsg.getEmailId());
//		user.setPassword("");

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}

}
