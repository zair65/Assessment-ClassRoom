package com.qa.persistence.repository;

public interface AccountRepository {

	String AddAccount(String account);
	String DeleteAccount(Long Id);
	String UpdateAccount(String firstName, String LastName, Long Id);
	String getAllAccounts();


}