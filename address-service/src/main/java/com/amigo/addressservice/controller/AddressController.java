package com.amigo.addressservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigo.addressservice.dto.AddressDto;
import com.amigo.addressservice.entities.Address;
import com.amigo.addressservice.exception.CityNotFound;
import com.amigo.addressservice.exception.CountryNotFound;
import com.amigo.addressservice.exception.StateNotFound;
import com.amigo.addressservice.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping(value = "/")
	public Address saveAddress(@RequestBody AddressDto addressDto) 
							throws StateNotFound, CityNotFound, CountryNotFound {
		
		return addressService.addAddress(addressDto);
	}
}
