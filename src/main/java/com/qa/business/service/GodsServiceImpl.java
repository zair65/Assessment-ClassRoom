
package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.GodsDBRepository;
import com.qa.persistence.repository.GodsRepository;

public class GodsServiceImpl implements GodsService {
	
	@Inject
	private GodsRepository repo;

	
	@Override
	public String getGods() {
		return repo.getGods();
	}
	
	@Override
	public String AddGod(String god) {
		// TODO Auto-generated method stub 
			return repo.AddGod(god); 
		}
	
	
	public void setRepo(GodsRepository repo) {
		this.repo = repo;
	}

	@Override
	public String DeleteGod(Long Id) {
		// TODO Auto-generated method stub
		return repo.DeleteGod(Id);
	}
	
	@Override
	public String UpdateGod(Long id,String god) {
		// TODO Auto-generated method stub
		return repo.UpdateGod(id,god);
	}

	

	

}