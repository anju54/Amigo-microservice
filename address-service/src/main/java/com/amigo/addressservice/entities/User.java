package com.amigo.addressservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TblUser")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "EmployeeCode", updatable = false, columnDefinition = "char")
	private String employeeCode;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "MiddleName")
	private String middleName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "FullName", insertable = false, updatable = false)
	private String fullName;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "MobileNumber")
	private String mobileNumber;

	@Column(name = "AlternateMobileNumber")
	private String alternateMobileNumber;

	@Column(name = "Email")
	private String email;

	@Column(name = "AlternateEmail")
	private String alternateEmail;
	
	@Column(name = "password")
	private String password;

	
}
