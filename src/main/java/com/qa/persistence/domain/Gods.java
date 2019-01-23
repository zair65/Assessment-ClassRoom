package com.qa.persistence.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Gods {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String God;
	private String GodType;
	private String Pantheon; 
	
	
	public Gods() {

	}
	
	public Gods (String God, String GodType,String Pantheon) {
		this.God = God;
		this.GodType = GodType;
		this.Pantheon = Pantheon;
	
	}

	public String getGod() {
		return God;
	}

	public void setGod(String god) {
		God = god;
	}

	public String getGodType() {
		return GodType;
	}

	public void setGodType(String godType) {
		GodType = godType;
	}

	public String getPantheon() {
		return Pantheon;
	}

	public void setPantheon(String pantheon) {
		Pantheon = pantheon;
	}



}