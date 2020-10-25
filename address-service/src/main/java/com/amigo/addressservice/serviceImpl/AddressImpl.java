package com.amigo.addressservice.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigo.addressservice.dto.AddressDto;
import com.amigo.addressservice.entities.Address;
import com.amigo.addressservice.entities.City;
import com.amigo.addressservice.entities.Country;
import com.amigo.addressservice.entities.State;
import com.amigo.addressservice.repository.AddressRepository;
import com.amigo.addressservice.repository.CityRepository;
import com.amigo.addressservice.repository.CountryRepository;
import com.amigo.addressservice.repository.StateRepository;
import com.amigo.addressservice.service.AddressService;
import com.amigo.addressservice.exception.CityNotFound;
import com.amigo.addressservice.exception.CountryNotFound;
import com.amigo.addressservice.exception.StateNotFound;

@Service
public class AddressImpl implements AddressService {
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	private static final Logger logger = LogManager.getLogger(AddressImpl.class);

	@Override
	public Address addAddress(AddressDto addressDto) throws StateNotFound, CityNotFound, CountryNotFound {
		
		City city  = cityRepository.findByCityName(addressDto.getCity());
		if(city==null) {
			System.out.println(city);
			logger.info("City "+addressDto.getCity()+" not found!!");
			throw new CityNotFound("City "+addressDto.getCity()+" not found!!");
		}
		
		State state = stateRepository.findByStateName(addressDto.getState());
		if(state==null) {
			System.out.println(state);
			logger.info("state "+addressDto.getState()+" not found!!");
			throw new StateNotFound("state " +addressDto.getState()+ " not found!!");
		}
		
		Country country = countryRepository.findByCountryName(addressDto.getCountry());
		if(country==null) {
			System.out.println(country);
			logger.info("country "+addressDto.getCountry()+" not found!!");
			throw new CountryNotFound("country " +addressDto.getCountry()+ " not found!!");
		}
		
		Address address = new Address();
		address.setCity(city);
		address.setCountry(country);
		address.setState(state);
		address.setAddressLine1(addressDto.getAddressLine1());
		address.setAddressLine2(addressDto.getAddressLine2());
		address.setPostalCode(addressDto.getPostalCode());
		//		address.setRecordCreated(null);
		//		address.setRecordUpdated(null);
		
		return addressRepository.save(address);
	}

}
