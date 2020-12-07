package com.amigo.authserver.service;

import com.amigo.authserver.entities.User;

public interface AuthService {
	
	void setPassword(User user);
	boolean validatePasswordResetToken(int userId, String token);
}
