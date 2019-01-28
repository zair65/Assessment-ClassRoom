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
import com.qa.business.service.GodsService;

@Path("/SmitePath")
public class SmiteEndpoint {
	
	@Inject
	private AccountService aservice;
	@Inject
	private GodsService gService;

	@Path("/UpdateAccount/{id}")
	@PUT
	@Produces({ "application/json" })
	public String UpdateAccount(@PathParam("id") Long id,String account) {
//		return service.retrieveAccounts(accNo);
		return aservice.UpdateAccount(id,account);}

	@Path("/AddAccount")
	@POST
	@Produces({ "application/json" })
	public String AddAccount(String account){
//		return service.addAccount(account);
		return aservice.AddAccount(account);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String DeleteAccount(@PathParam("id") Long id) {
//		return service.addAccount(account);
		return aservice.DeleteAccount(id);
	}

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts()   {
//		return service.addAccount(account);
		return aservice.getAllAccounts();
	}
	
	@Path("/getGods")
	@GET
	@Produces({ "application/json" })
	public String getGods()   {
//		return service.addAccount(account);
		return gService.getGods();
	}
	
	

		public void setService(AccountService service) {
		this.aservice = service;
	}

}