package com.amigo.authserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amigo.authserver.entities.User;
import com.amigo.authserver.repository.UserRepository;

/**
 * This class implements {@link UserDetailsService} which is predefined in
 * spring security to perform some user security related operations.
 * 
 * @author Anju
 * @version 1.0
 * 
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * loadUserByUsername is spring security method to load the current user
	 * 
	 * @return User
	 * 	
	 */
	@Override
	public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email);
				
		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+email);
		}

		return new CustomUserDetails(user);
	}

}
