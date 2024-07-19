package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AppreciationDao;
import com.youtube.jwt.dao.AwardListDao;
import com.youtube.jwt.dao.EmployeeDao;
import com.youtube.jwt.entity.Appericiation;
import com.youtube.jwt.entity.AwardList;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.exception.EntityNotFoundException;

@Service
public class AppericiationService {
	@Autowired
	private AppreciationDao appreciationDao;
	@Autowired
	private AwardListDao awardListDao;
	@Autowired
	private EmployeeDao employeeDao;

	public Appericiation saveAppericiation(Appericiation appericiation) {
		AwardList awardList = awardListDao.findById(appericiation.getAwardIId())
				.orElseThrow(() -> new RuntimeException("Award not found"));
		appericiation.setAwardList(awardList);
		;
		Employee employee = employeeDao.findById(appericiation.getEmployeesId())
				.orElseThrow(() -> new RuntimeException("Employee not found"));
		appericiation.setEmployee(employee);
		;
		Appericiation savedAppericiation = appreciationDao.save(appericiation);
		return savedAppericiation;
	}

	public List<Appericiation> getAllAppericiation() {
		return appreciationDao.findAll();
	}

	public Appericiation getAppericiationById(Long proposalId) {
		return appreciationDao.findById(proposalId).orElseThrow(() -> new RuntimeException("Proposal not found"));
	}

	public void deleteAppericiation(Long id) {
        Optional<Appericiation> appericiation = appreciationDao.findById(id);
        if (appericiation.isPresent()) {
        	appreciationDao.deleteById(id);
        } else {
            throw new EntityNotFoundException("Appericiation with ID " + id + " not found.");
        }
    }
}
