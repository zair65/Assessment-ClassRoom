package com.qa.business.service;

public interface GodsService {
	
	String getGods();
	String AddGod(String god);
	String DeleteGod(Long Id);
	String UpdateGod(Long id, String god);
}