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
	private Long ClassRoomId ;
	
	
	 @ManyToMany(cascade = CascadeType.ALL)
	  private List<Trainee> Trainees;
	
	public ClassRoom() {

	}
	
	public ClassRoom (String TrainerName, Long ClassRoomId) {
		this.TrainerName = TrainerName;
		this.ClassRoomId = ClassRoomId;
	}

	public String getTrainerName() {
		return TrainerName;
	}

	public void setTrainerName(String TrainerName) {
		this.TrainerName = TrainerName;
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