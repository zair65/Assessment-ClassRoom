
package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Gods;
import com.qa.util.JSONUtil;

@Default
public class GodsDBRepository implements GodsRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	public String getGods() {
		Query query = manager.createQuery("Select g FROM Gods g");
		Collection<Gods> result = (Collection<Gods>) query.getResultList();
		return util.getJSONForObject(result);
	}
	
	@Override
	@Transactional(REQUIRED)
	public String AddGod(String god) {
		Gods aGod = util.getObjectForJSON(god, Gods.class);
		manager.persist(aGod);
		return "{\"message\": \"god has been sucessfully added\"}";
	}
	
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}