package com.qa.business.service;

public interface ClassRoomService {

	String AddTrainee(String TraineeName);
	String DeleteTrainee(Long TraineeId);
	String UpdateTrainee(String TraineeName, Long Id);
	String getAllTrainee();

}