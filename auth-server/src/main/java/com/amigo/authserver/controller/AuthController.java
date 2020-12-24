package com.amigo.authserver.controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amigo.authserver.constants.MessagingConstants;
import com.amigo.authserver.dto.LoginDTO;
import com.amigo.authserver.entities.User;
import com.amigo.authserver.repository.UserRepository;

import com.amigo.authserver.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private RabbitTemplate template;
	
//	@Autowired
//    private AuthenticationManager authenticationManager; // Checks user authentication
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;			 // Generates the token

    @Autowired
	private UserRepository userRepository;
    
    //private final static Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	/**
     * Maps user token generation request and extracts user name and password from
     * request.
     * 
     * @param loginUser User model for login
     * @return ResponseEntity
     * @throws AuthenticationException
     */
//    @PostMapping(value="/login")
//    public ResponseEntity<?> generateToken(@RequestBody LoginDTO loginUser) throws AuthenticationException {
//    	
//    logger.info("trying to login to the system");
//
//	// Create new authentication token
//	UsernamePasswordAuthenticationToken authenticationToken = 
//		new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword());
//	
//	// Set authentication manager with the authentication token
//	Authentication authentication = authenticationManager.authenticate(authenticationToken);
//
//	// Set authentication to security context, handles authentication
//	SecurityContextHolder.getContext().setAuthentication(authentication);
//	
//	// Get the user requesting for authentication
//	User user = userRepository.findByEmail(loginUser.getEmail());
//			
//	
//	// Generate the JWT token for user
//	final String token = jwtTokenUtil.generateToken(user);
//	
//	return ResponseEntity.ok(new AuthToken(token));
//    }

	
	@PostMapping("/set-password/")
	public void setPassword(@RequestParam("token") String token, @RequestParam("id") int userId, 
			@RequestBody User user) {
		
		boolean res = authService.validatePasswordResetToken(userId,token);
		
		authService.setPassword(user);
		
		template.convertAndSend(MessagingConstants.EXCHANGE,MessagingConstants.SET_PASSWORD_KEY,user);
	}

	@GetMapping("/all")
	public List<User> getListOfUser() {
		
		return userRepository.findAll();
		
	}
}
