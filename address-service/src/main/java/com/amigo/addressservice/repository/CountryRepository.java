package com.amigo.addressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amigo.addressservice.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer>{

	Country findByCountryName(String countryName);
}
