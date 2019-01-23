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

import com.qa.business.service.ClassRoomService;
import com.qa.business.service.GodsService;

@Path("/trainees")
public class ClassRoomEndpoint {
	
	@Inject
	private ClassRoomService aservice;
	@Inject
	private GodsService gService;

	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String UpdateTrainee(@PathParam("id") String TraineeName, Long Id) {
//		return service.retrieveAccounts(accNo);
		return aservice.UpdateTrainee(TraineeName, Id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String AddTrainee(@PathParam("id") String TraineeName){
//		return service.addAccount(account);
		return aservice.AddTrainee(TraineeName);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String DeleteTrainee(@PathParam("id") Long Id) {
//		return service.addAccount(account);
		return aservice.DeleteTrainee(Id);
	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainee()   {
//		return service.addAccount(account);
		return aservice.getAllTrainee();
	}
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getGods()   {
//		return service.addAccount(account);
		return gService.getGods();
	}
	
	

		public void setService(ClassRoomService service) {
		this.aservice = service;
	}

}