package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ClassRoom {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String TrainerName;
	private String TraineeName;
	private Long TraineeId;
	private Long ClassRoomId ;
	
	
	public ClassRoom() {

	}
	
	public ClassRoom (String TrainerName, String TraineeName,Long TraineeId, Long ClassRoomId) {
		this.TrainerName = TrainerName;
		this.ClassRoomId = ClassRoomId;
		this.TraineeName = TraineeName;
		this.TraineeId = TraineeId;
	
	}

	public String getTrainerName() {
		return TrainerName;
	}

	public void setTrainerName(String TrainerName) {
		this.TrainerName = TrainerName;
	}

	public String getTraineeName(String TraineeName) {
		return TrainerName;
	}

	public void setTraineeName(String TraineeName) {
		this.TraineeName = TraineeName;
	}
	
	
	public Long getTraineeId() {
		return TraineeId;
	}

	public void setTraineeId(Long TraineeId) {
		this.TraineeId = TraineeId;
	}
	
	
	public Long getClassRoomId() {
		return ClassRoomId;
	}

	public void setClassRoomId(Long ClassRoomId) {
		this.ClassRoomId = ClassRoomId;
	}


	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		return TrainerName + ClassRoomId;
	}
	

}