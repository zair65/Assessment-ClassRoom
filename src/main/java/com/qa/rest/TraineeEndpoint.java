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

import com.qa.business.service.TraineeService;

@Path("/TraineeStudents")
public class TraineeEndpoint {
	
	@Inject
	private TraineeService service;

	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String UpdateTrainee(@PathParam("id") String TraineeName, Long Id) {
//		return service.retrieveAccounts(accNo);
		return service.UpdateTrainee(TraineeName, Id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String AddTrainee(@PathParam("id") String TraineeStudents){
//		return service.addAccount(account);
		return service.AddTrainee(TraineeStudents);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String DeleteTrainee(@PathParam("id") Long Id) {
//		return service.addAccount(account);
		return service.DeleteTrainee(Id);
	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainee()   {
//		return service.addAccount(account);
		return service.getAllTrainee();
	}

		public void setService(TraineeService service) {
		this.service = service;
	}

}