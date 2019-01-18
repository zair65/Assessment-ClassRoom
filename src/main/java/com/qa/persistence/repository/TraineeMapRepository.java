package com.qa.persistence.repository;

	import static javax.transaction.Transactional.TxType.REQUIRED;
	import static javax.transaction.Transactional.TxType.SUPPORTS;

	import java.util.Collection;
	import java.util.List;

	import javax.enterprise.inject.Alternative;
	import javax.inject.Inject;
	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.persistence.Query;
	import javax.transaction.Transactional;

	import org.apache.log4j.Logger;

import com.qa.business.service.ClassRoomService;
import com.qa.persistence.domain.ClassRoom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

	@Transactional(SUPPORTS)
	@Alternative
	public class TraineeMapRepository implements ClassRoomRepository {
		
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;

		@Inject
		private JSONUtil util;
		

		
		@Override
		public String getAllTrainee() {
			// TODO Auto-generated method stub
			Query query = manager.createQuery("Select a FROM ClassRoom a");
			Collection<ClassRoom> result = (Collection<ClassRoom>) query.getResultList();
			return util.getJSONForObject(result);
		}
			
		@Override
		@Transactional(REQUIRED)
		public String AddTrainee(String TraineeStudents) {
			ClassRoom aTrainee = util.getObjectForJSON(TraineeStudents, ClassRoom.class);
			manager.persist(aTrainee);
			return "{\"message\": \"Trainee has been sucessfully added\"}";
		}


		@Override
		@Transactional(REQUIRED)
		public String DeleteTrainee(Long id) {
			Trainee accountInDB = findTrainee(id);
			if (accountInDB != null) {
				manager.remove(accountInDB);
				return "{\"message\": \"Trainee sucessfully deleted\"}";
			}
			return "{\"message\": \"Trainee not found\"}";
		}
		
		
		@Override
		@Transactional(REQUIRED)
		public String UpdateTrainee(String TraineeName,Long Id) {
			Trainee changeTrainee=findTrainee(Id);
					changeTrainee.setTraineeName(TraineeName); 
					changeTrainee.setTraineeId(Id);
					
					return "{\"message\": \"Trainee has been sucessfully updated\"}";
		}

		
		private Trainee findTrainee(Long Id) {
			return manager.find(Trainee.class, Id);
		}
		
		public void setManager(EntityManager manager) {
			this.manager = manager;
		}

		public void setUtil(JSONUtil util) {
			this.util = util;
		}

	
}
