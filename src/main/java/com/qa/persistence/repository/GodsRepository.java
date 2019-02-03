package com.qa.persistence.repository;

public interface GodsRepository {
	
	String getGods();
	String AddGod(String god);
	String DeleteGod(Long id);
	String UpdateGod(Long id, String gods);
}
