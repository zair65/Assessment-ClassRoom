
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
		return "{\"message\": \"God has been sucessfully added\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String DeleteGod(Long id) {
		Gods godInDB = findGod(id);
		if (godInDB != null) {
			manager.remove(godInDB);
			return "{\"message\": \"God sucessfully deleted\"}";
		}
		return "{\"message\": \"God not found\"}";
	}
	
	
	@Override
	@Transactional(REQUIRED)
	public String UpdateGod(Long id,String gods) {
		
		Gods godsInDB = findGod(id);
		if (godsInDB != null) {
			Gods changes = util.getObjectForJSON(gods,Gods.class);
			godsInDB.setGod(changes.getGod());
			godsInDB.setGodType(changes.getGodType());
			godsInDB.setPantheon(changes.getPantheon());
		}
		return "{\"message\": \"God has been sucessfully amended\"}";
	}
	
	private Gods findGod(Long id) {
		return manager.find(Gods.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}