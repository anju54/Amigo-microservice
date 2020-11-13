package com.amigo.authserver.entities;

import lombok.Data;

@Data
public class User {

	int userId;
	String email;
	String password;
	String token;
}
