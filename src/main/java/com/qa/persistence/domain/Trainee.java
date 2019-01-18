package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String TraineeName;
	private Long TraineeId ;
	private Long ClassRoomId;
	
	
	public Trainee() {

	}
	
	public Trainee (String TraineeName, Long TraineeId, Long ClassRoomId) {
		this.TraineeName = TraineeName;
		this.TraineeId =TraineeId;
	}

	public String getTraineeName() {
		return TraineeName;
	}

	public void setTraineeName(String TrainerName) {
		this.TraineeName = TraineeName;
	}

	public Long getClassRoomId() {
		return ClassRoomId;
	}

	public void setClassRoomId(Long ClassRoomId) {
		this.ClassRoomId = ClassRoomId;
	}

	
	public Long getTraineeId() {
		return TraineeId;
	}

	public void setTraineeId(Long TraineeId) {
		this.TraineeId = TraineeId;
	}
	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		return TraineeName + ClassRoomId;
	}
	

}
