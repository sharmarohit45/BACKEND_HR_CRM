package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Admin;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.service.AdminService;
import com.youtube.jwt.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AdminController {

	@Autowired
    private AdminService adminService;
	
	
	@PostMapping("/admin")
    public ResponseEntity<Admin> saveClient(@RequestBody Admin admin) {
		Admin savedClient = adminService.saveAdmin(admin);
        return ResponseEntity.ok(savedClient);
    }
	@GetMapping("path")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	@GetMapping("/admin/data")
	public List<Admin> getAdminData() {
        return adminService.getAdminData();
    }
	 @PutMapping("/admin/{id}")
	    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
	        Admin admin = adminService.updateEmployee(id, updatedAdmin);
	        return ResponseEntity.ok(admin);
	    }
}
