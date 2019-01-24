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

	import com.qa.business.service.AccountService;
	import com.qa.persistence.domain.Account;
	import com.qa.util.JSONUtil;

	@Transactional(SUPPORTS)
	@Alternative
	public class AccountMapRepository implements AccountRepository {
		
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;

		@Inject
		private JSONUtil util;
		

		
		@Override
		public String getAllAccounts() {
			// TODO Auto-generated method stub
			Query query = manager.createQuery("Select a From Account a");
			Collection<Account> result = (Collection<Account>) query.getResultList();
			return util.getJSONForObject(result);
		}
			
		@Transactional(REQUIRED)
		@Override
		public String AddAccount(String account) {
			// TODO Auto-generated method stub
			Account anAccount = util.getObjectForJSON(account, Account.class);
			manager.persist(anAccount);
			return "{\"message\": \"account has been sucessfully added\"}";
		}

		@Override
		@Transactional(REQUIRED)
		public String DeleteAccount(Long id) {
			Account accountInDB = findAccount(id);
			if (accountInDB != null) {
				manager.remove(accountInDB);
				return "{\"message\": \"account sucessfully deleted\"}";
			}
			return "{\"message\": \"account not found\"}";
		}
		
		
		@Override
		@Transactional(REQUIRED)
		public String UpdateAccount(String UserName, String Password,Long Id) {
			Account changeAccount=findAccount(Id);
					changeAccount.setUserName(UserName); 
					changeAccount.setPassword(Password);
					
					return "{\"message\": \"account sucessfully Updated\"}";
				
		}
		
		private Account findAccount(Long id) {
			return manager.find(Account.class, id);
		}
		
		public void setManager(EntityManager manager) {
			this.manager = manager;
		}

		public void setUtil(JSONUtil util) {
			this.util = util;
		}


		

	
	
	
	
}
