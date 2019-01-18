package com.qa.persistence.repository;

public interface ClassRoomRepository {

	String AddTrainee(String TraineeName);
	String DeleteTrainee(Long Id);
	String UpdateTrainee(String TraineeName, Long Id);
	String getAllTrainee();


}