package com.qa.persistence.repository;

public interface TraineeRepository {

	String AddTrainee(String trainees);
	String DeleteTrainee(Long Id);
	String UpdateTrainee(String TraineeName, Long Id);
	String getAllTrainee();


}