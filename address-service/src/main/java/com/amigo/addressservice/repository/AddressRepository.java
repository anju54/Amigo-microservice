package com.amigo.addressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amigo.addressservice.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
