package com.amigo.addressservice.service;

import com.amigo.addressservice.dto.AddressDto;
import com.amigo.addressservice.entities.Address;
import com.amigo.addressservice.exception.CityNotFound;
import com.amigo.addressservice.exception.CountryNotFound;
import com.amigo.addressservice.exception.StateNotFound;

public interface AddressService {

	Address addAddress(AddressDto addressDto) throws StateNotFound, CityNotFound, CountryNotFound;
}
