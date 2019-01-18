package com.qa.business.service;

public interface ClassRoomService {

	String AddTrainee(String TraineeName, Long TraineeId);
	String DeleteTrainee(Long TraineeId);
	String UpdateTrainee(String TraineeName);
	String getAllTrainee();

}