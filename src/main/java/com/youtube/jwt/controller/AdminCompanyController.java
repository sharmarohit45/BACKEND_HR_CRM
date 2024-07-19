package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.youtube.jwt.entity.AdminCompanySetting;
import com.youtube.jwt.service.AdminCompanySettingService;

@RestController
public class AdminCompanyController {
	
	@Autowired
	private AdminCompanySettingService AdminCompanySettingService;
	
	@PostMapping("/company")
	public ResponseEntity<AdminCompanySetting> saveAccount(@RequestBody AdminCompanySetting adminCompanySetting) {
		try {
			AdminCompanySetting savedaccount = AdminCompanySettingService.savedata(adminCompanySetting);
			return ResponseEntity.ok(savedaccount);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/company")
	public List<AdminCompanySetting> getSaveAccount() {
		return AdminCompanySettingService.getSaveAccount();
	}


}
