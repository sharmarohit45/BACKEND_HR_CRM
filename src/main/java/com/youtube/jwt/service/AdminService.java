package com.youtube.jwt.service;
 import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AdminDao;
import com.youtube.jwt.dao.ClientDao;
import com.youtube.jwt.entity.Admin;
import com.youtube.jwt.entity.Client;
 
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
	
	

}
