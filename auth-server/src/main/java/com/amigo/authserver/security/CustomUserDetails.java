package com.amigo.authserver.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.amigo.authserver.entities.User;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String fName;
	private String lName;
	private String role;
	private User user;

	public CustomUserDetails(User user) {
		
		super(user.getEmail(), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRole().getRoleName()));
		
		this.role = user.getRole().getRoleName();
		this.user = user;
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<String> roles = Arrays.asList(this.user.getRole().getRoleName());
		return AuthorityUtils.createAuthorityList(roles.toArray(new String[roles.size()]));
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
