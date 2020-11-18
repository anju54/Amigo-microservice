package com.amigo.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amigo.authserver.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * This will find the last record of user table
	 * @return
	 */
	public User findTopByOrderByIdDesc();
	
	public User findByEmail(String email);
}
