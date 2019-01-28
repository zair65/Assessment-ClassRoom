package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String UserName;
	private String Password;

	
	
	public Account() {

	}
	
	public Account (String UserName, String Password) {
		this.UserName = UserName;
		this.Password =Password;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


	
	
}


