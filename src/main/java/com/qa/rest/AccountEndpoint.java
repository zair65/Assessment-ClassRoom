package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private AccountService service;

	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String UpdateAccount(@PathParam("id") String firstName, String LastName, Long Id) {
//		return service.retrieveAccounts(accNo);
		return service.UpdateAccount(firstName, LastName, Id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String AddAccount(@PathParam("id") String account){
//		return service.addAccount(account);
		return service.AddAccount(account);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String DeleteAccount(@PathParam("id") Long Id) {
//		return service.addAccount(account);
		return service.DeleteAccount(Id);
	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts()   {
//		return service.addAccount(account);
		return service.getAllAccounts();
	}

		public void setService(AccountService service) {
		this.service = service;
	}

}