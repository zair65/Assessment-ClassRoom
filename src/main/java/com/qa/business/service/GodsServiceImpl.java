
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
	
	public void setRepo(GodsRepository repo) {
		this.repo = repo;
	}

	

	

}