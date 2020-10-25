package com.amigo.addressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amigo.addressservice.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State,Integer> {

	State findByStateName(String stateName);
}
