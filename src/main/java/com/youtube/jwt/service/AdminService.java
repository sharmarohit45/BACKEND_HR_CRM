package com.youtube.jwt.service;
 import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youtube.jwt.dao.AdminDao;
import com.youtube.jwt.dao.ClientDao;
import com.youtube.jwt.entity.Admin;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.exception.EntityNotFoundException;
 
 @Service
 public class AdminService {
	 
	 @Autowired
	    private AdminDao adminDao;
	 
	 @Autowired
	    private PasswordEncoder passwordEncoder;

	    public Admin saveAdmin(Admin admin) {
	    	String encodedPassword = passwordEncoder.encode(admin.getPassword());
	    	admin.setPassword(encodedPassword);
	        return adminDao.save(admin);
	    }


	    
	    public String getEncodedPassword(String password) {
	        return passwordEncoder.encode(password);
	    }



		public List<Admin> getAdminData() {
			List<Admin> admin = new ArrayList<>();
			adminDao.findAll().forEach(admin::add);
			return admin;
		}
		
		@Transactional
	    public Admin updateEmployee(Long adminId, Admin updatedAdmin) {
	        Optional<Admin> adminOptional = adminDao.findById(adminId);

	        if (adminOptional.isPresent()) {
	            Admin existingAdmin = adminOptional.get();

	            if (updatedAdmin.getAdminName() != null) {
	            	existingAdmin.setAdminName(updatedAdmin.getAdminName());
	            }
	            if (updatedAdmin.getEmail() != null) {
	            	existingAdmin.setEmail(updatedAdmin.getEmail());;
	            }
	            if (updatedAdmin.getPassword() != null) {
	            	existingAdmin.setPassword(passwordEncoder.encode(updatedAdmin.getPassword()));
	            }
	            if (updatedAdmin.getCountry() != null) {
	            	existingAdmin.setCountry(updatedAdmin.getCountry());
	            }
	            if (updatedAdmin.getMobileNo() != null) {
	            	existingAdmin.setMobileNo(updatedAdmin.getMobileNo());
	            }
	            if (updatedAdmin.getFileData() != null) {
	            	existingAdmin.setFileData(updatedAdmin.getFileData());
	            }
	           
	            if (updatedAdmin.getEmailNotification() != null) {
	            	existingAdmin.setEmailNotification(updatedAdmin.getEmailNotification());
	            }
	            if (updatedAdmin.getGoogleCalender() != null) {
	            	existingAdmin.setGoogleCalender(updatedAdmin.getGoogleCalender());
	            }
	            if (updatedAdmin.getDateOfBirth() != null) {
	            	existingAdmin.setDateOfBirth(updatedAdmin.getDateOfBirth());
	            }
	            if (updatedAdmin.getSlackMemberId() != null) {
	            	existingAdmin.setSlackMemberId(updatedAdmin.getSlackMemberId());
	            }
	            if (updatedAdmin.getMaritialStatus() != null) {
	            	existingAdmin.setMaritialStatus(updatedAdmin.getMaritialStatus());
	            }
	            if (updatedAdmin.getAddress() != null) {
	            	existingAdmin.setAddress(updatedAdmin.getAddress());;
	            }
	            if (updatedAdmin.getAbout() != null) {
	            	existingAdmin.setAbout(updatedAdmin.getAbout());;
	            }
	            return adminDao.save(existingAdmin);
	        } else {
	            throw new EntityNotFoundException("Employee not found with id: " + adminId);
	        }
	    }
	
	

}
