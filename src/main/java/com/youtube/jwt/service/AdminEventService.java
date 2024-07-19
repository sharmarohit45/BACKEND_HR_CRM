package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AdminEventDao;
import com.youtube.jwt.entity.AdminEvent;

@Service
public class AdminEventService {
	@Autowired
	private AdminEventDao adminEventDao;
	
	public AdminEvent saveEvent(AdminEvent adminEvent) {
		return adminEventDao.save(adminEvent);
	}
	public List<AdminEvent> getAllEvent() {
		return adminEventDao.findAll();
	}

}
