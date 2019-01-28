package com.qa.business.service;

public interface AccountService {

	String AddAccount(String account);
	String DeleteAccount(Long Id);
	String getAllAccounts();
	String UpdateAccount(Long id, String account);

}