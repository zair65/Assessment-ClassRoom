package com.qa.business.service;



import javax.inject.Inject;

import com.google.gson.Gson;
import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImpl implements TraineeService {
	
	@Inject 
	private TraineeRepository repo; 
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
	public String getAllTrainee() {
//		return gson.toJson(account);
		return repo.getAllTrainee();
	}
		
	
	@Override
	public String AddTrainee(String TraineeStudents) {
		// TODO Auto-generated method stub
		
			return repo.AddTrainee(TraineeStudents); 
		
	}

	@Override
	public String DeleteTrainee(Long Id) {
		// TODO Auto-generated method stub
		return repo.DeleteTrainee(Id);
	}



	@Override
	public String UpdateTrainee(String TraineeName, Long Id) {
		// TODO Auto-generated method stub
		 return repo.UpdateTrainee(TraineeName,Id);
	}




	
}