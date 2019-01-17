package com.qa.business.service;

import java.util.HashMap;

import javax.inject.Inject;

import com.google.gson.Gson;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountServiceImpl implements AccountService {
	
	@Inject 
	private AccountRepository repo; 
	private JSONUtil util; 
	
//	Gson gson = new Gson();
	
//HashMap<Integer, Account> account = new HashMap<>();
//	
//	int counter = 1;
//	
//	@Override
//	public void addAccount(String firstName, String lastName) {
//		account.put(counter, new Account(firstName, lastName, counter));
//		counter++;
//	}
//	
//	@Override
//	public Account retrieveAccount(int accountNumber) {
//		return account.get(accountNumber);
//	}
		
	
	@Override
	public String getAllAccounts() {
//		return gson.toJson(account);
		return repo.getAllAccounts();
	}
		
	
	@Override
	public String AddAccount(String account) {
		// TODO Auto-generated method stub
		
		if(util.getObjectForJSON(account, Account.class).getAccountNumber().equals("9999"))  { 
			return "{'message':'Account has been blocked'}";
		}   else { 
			return repo.AddAccount(account); 
		}
		
	}

	@Override
	public String DeleteAccount(Long Id) {
		// TODO Auto-generated method stub
		return repo.DeleteAccount(Id);
	}
	
	@Override
	public String UpdateAccount(String firstName, String LastName, Long Id) {
		// TODO Auto-generated method stub
		return repo.UpdateAccount(firstName,LastName,Id);
	}

	
}