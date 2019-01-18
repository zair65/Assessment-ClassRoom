package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.ClassRoom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassRoomDBRepository implements ClassRoomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	
	@Override
	public String getAllTrainee() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<ClassRoom> result = (Collection<ClassRoom>) query.getResultList();
		return util.getJSONForObject(result);
	}
	
	@Override
	@Transactional(REQUIRED)
	public String AddTrainee(String Trainees) {
		ClassRoom aTrainee = util.getObjectForJSON(Trainees, ClassRoom.class);
		manager.persist(aTrainee);
		return "{\"message\": \"Trainee has been sucessfully added\"}";
	}


	@Override
	@Transactional(REQUIRED)
	public String DeleteTrainee(Long id) {
		ClassRoom accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
			return "{\"message\": \"account sucessfully deleted\"}";
		}
		return "{\"message\": \"account not found\"}";
	}
	
	
	@Override
	@Transactional(REQUIRED)
	public String UpdateTrainee(String TraineeName,Long Id) {
		ClassRoom changeTrainee=findAccount(Id);
				changeTrainee.setTraineeName(TraineeName); 
				changeTrainee.setTraineeId(Id);
				
				return "{\"message\": \"Trainee has been sucessfully updated\"}";
	}

	
	private ClassRoom findAccount(Long id) {
		return manager.find(ClassRoom.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	



}
