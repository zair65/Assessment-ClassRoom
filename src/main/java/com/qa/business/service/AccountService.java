package com.qa.business.service;

public interface AccountService {

	String AddAccount(String account);
	String DeleteAccount(Long Id);
	String UpdateAccount(String firstName, String LastName, Long Id);
	String getAllAccounts();

}