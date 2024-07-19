package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AdminLeaveDao;
import com.youtube.jwt.dao.EmployeeDao;
import com.youtube.jwt.entity.AdminLeave;
import com.youtube.jwt.entity.Employee;

@Service
public class AdminLeaveService {
	@Autowired
	private AdminLeaveDao adminLeaveDao;

	@Autowired
	private EmployeeDao employeeDao;

	public AdminLeave saveLeave(AdminLeave adminLeave) {
		Employee employee = employeeDao.findById(adminLeave.getEmployeeIId())
				.orElseThrow(() -> new RuntimeException("Lead not found"));
		adminLeave.setEmployee(employee);
		AdminLeave savedLeave = adminLeaveDao.save(adminLeave);
		return savedLeave;
	}

	public List<AdminLeave> getAllLeaves() {
		return adminLeaveDao.findAll();
	}

	public AdminLeave getLeaveById(Long leaveId) {
		return adminLeaveDao.findById(leaveId).orElseThrow(() -> new RuntimeException("Leave not found"));
	}

	public AdminLeave updateLeave(Long leaveId, AdminLeave updatedLeave) {
		AdminLeave existingLeave = adminLeaveDao.findById(leaveId)
				.orElseThrow(() -> new RuntimeException("Leave not found"));
		existingLeave.setLeaveType(updatedLeave.getLeaveType());
		existingLeave.setStatus(updatedLeave.getStatus());
		existingLeave.setLeaveDuration(updatedLeave.getLeaveDuration());
		existingLeave.setLeaveDate(updatedLeave.getLeaveDate());
		existingLeave.setAbsenceReason(updatedLeave.getAbsenceReason());

		return adminLeaveDao.save(existingLeave);
	}

	public void deleteLeave(Long leaveId) {
		AdminLeave existingLeave = adminLeaveDao.findById(leaveId)
				.orElseThrow(() -> new RuntimeException("Leave not found"));

		adminLeaveDao.delete(existingLeave);
	}
}
