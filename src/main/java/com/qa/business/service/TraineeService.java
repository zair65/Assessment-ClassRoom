package com.qa.business.service;

public interface TraineeService {

	String AddTrainee(String TraineeStudents);
	String DeleteTrainee(Long TraineeId);
	String UpdateTrainee(String TraineeName, Long Id);
	String getAllTrainee();

}