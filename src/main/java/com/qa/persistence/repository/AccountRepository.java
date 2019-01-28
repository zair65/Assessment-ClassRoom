package com.qa.persistence.repository;

public interface AccountRepository {

	String AddAccount(String account);
	String DeleteAccount(Long id);
	String getAllAccounts();
	String UpdateAccount(Long id,String account);


}