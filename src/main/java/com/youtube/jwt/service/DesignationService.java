package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.DesignationDao;
import com.youtube.jwt.entity.Admin;
import com.youtube.jwt.entity.Designations;

@Service
public class DesignationService {
	@Autowired
	private DesignationDao designationDao;

	public Designations saveDesignation(Designations designation) {
		return designationDao.save(designation);
	}

	public List<Designations> getAllDesignations() {
		return designationDao.findAll(); // Or whatever method is used in your DAO
	}

}
