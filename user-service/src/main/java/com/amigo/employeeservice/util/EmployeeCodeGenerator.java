package com.amigo.employeeservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amigo.employeeservice.service.UserService;

@Component
public class EmployeeCodeGenerator {
	
	@Autowired
	private UserService userDao;
	
	public String getNextEmployeeCode() {
		
		String employeeCode = null;
		
		int employeeId = userDao.getLastUserId();
		
		/*
		 * For 1st employee the employeeCode is "amigo-0001" after that it increased by 1
		 */
		if (employeeId == 0) {
			employeeCode = "amigo-00001";
		} else {
			
			employeeId += 1;

			if (employeeId <= 9) {
				employeeCode = "amigo-0000" + employeeId;
			} else if (employeeId <= 99) {
				employeeCode = "amigo-000" + employeeId;
			} else if (employeeId <= 999) {
				employeeCode = "amigo-00" + employeeId;
			} else if (employeeId <= 9999) {
				employeeCode = "amigo-0" + employeeId;
			} else {
				employeeCode = "amigo-" + employeeId;
			}
		}

		return employeeCode;
	}

}
