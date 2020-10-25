package com.amigo.addressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigo.addressservice.entities.City;

public interface CityRepository extends JpaRepository<City,Integer> {

	City findByCityName(String cityName);
}
