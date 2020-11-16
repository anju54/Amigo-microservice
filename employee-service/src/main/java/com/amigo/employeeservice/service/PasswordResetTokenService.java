package com.amigo.employeeservice.service;

import com.amigo.employeeservice.entities.PasswordResetToken;

public interface PasswordResetTokenService {

	PasswordResetToken createToken(int userId) ;
}
