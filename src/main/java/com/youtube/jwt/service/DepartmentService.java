package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.DepartmentDao;
import com.youtube.jwt.entity.Deals;
import com.youtube.jwt.entity.Department;
import com.youtube.jwt.entity.Designations;
import com.youtube.jwt.entity.Lead;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	public Department saveDepartment(Department department) {
		return departmentDao.save(department);
	}

	public List<Department> getAllDepartment() {
		return departmentDao.findAll(); // Or whatever method is used in your DAO
	}

	public Department updateDepartment(Long departmentId, Department updatedDepartment) {
		Department existingDepartment = departmentDao.findById(departmentId)
				.orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
		existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());
		existingDepartment.setDepartmentParent(updatedDepartment.getDepartmentParent());

		// Save the updated department back to the database
		return departmentDao.save(existingDepartment);
	}
	public void deleteDepartment(Long id) {
        departmentDao.deleteById(id);
    }

}
