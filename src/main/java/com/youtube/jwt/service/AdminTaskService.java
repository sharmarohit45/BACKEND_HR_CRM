package com.youtube.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.youtube.jwt.dao.AdminTaskDao;
import com.youtube.jwt.dao.EmployeeDao;
import com.youtube.jwt.entity.AdminTask;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Project;

@Service
public class AdminTaskService {

	@Autowired
	private AdminTaskDao adminTaskDao;

	@Autowired
	private EmployeeDao employeeDao;

	public List<AdminTask> getAllTask() {
		return adminTaskDao.findAll();
	}

	public AdminTask savetask(AdminTask adminTask) {
		return adminTaskDao.save(adminTask);
	}

	public Optional<AdminTask> getTaskById(Long id) {
		return adminTaskDao.findById(id);
	}

	public void deleteTask(Long id) {
		adminTaskDao.deleteById(id);
	}

	public AdminTask createTaskWithMembers(AdminTask adminTask) {
		List<Employee> members = new ArrayList<>();
		for (Long employeeId : adminTask.getEmployeeIds()) {
			Optional<Employee> employeeOptional = employeeDao.findById(employeeId);
			employeeOptional.ifPresent(members::add);
		}
		adminTask.setAssignedto(members);
		return adminTaskDao.save(adminTask);
	}
	
	 public AdminTask saveTask(AdminTask adminTask) {
			/*
			 * if (adminTask.getAddFileData() != null &&
			 * StringUtils.hasText(adminTask.getAddFile())) { String directoryPath =
			 * "src/TaskFile"; String imagePath =
			 * ImageFileHandler.saveImageDataToFile(directoryPath, adminTask.getAddFile(),
			 * adminTask.getAddFileData()); if (imagePath != null) {
			 * adminTask.setAddFile(imagePath); } else { // Handle the case where image
			 * saving fails } }
			 */
			 
	        List<Employee> members = new ArrayList<>();
	        for (Long employeeId : adminTask.getEmployeeIds()) {
	            Optional<Employee> employeeOptional = employeeDao.findById(employeeId);
	             System.out.println(employeeOptional);
	            employeeOptional.ifPresent(members::add);
	        }
	        adminTask.setAssignedto(members); 
	        return adminTaskDao.save(adminTask);
	    }

}
