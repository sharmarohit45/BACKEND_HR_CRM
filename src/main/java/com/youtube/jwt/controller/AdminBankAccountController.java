package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.entity.AdminAccount;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.exception.EntityNotFoundException;
import com.youtube.jwt.service.AdminBankAccountService;

@RestController
public class AdminBankAccountController {

	@Autowired
	private AdminBankAccountService adminBankAccountService;

	@PostMapping("/account")
	public ResponseEntity<AdminAccount> saveAccount(@RequestBody AdminAccount adminAccount) {
		try {
			AdminAccount savedaccount = adminBankAccountService.saveAccount(adminAccount);
			return ResponseEntity.ok(savedaccount);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/account-data")
	public List<AdminAccount> getSaveAccount() {
		return adminBankAccountService.getSaveAccount();
	}

	@DeleteMapping("/accounts/{accountId}")
	public ResponseEntity<Void> deleteAccount(@PathVariable("accountId") Long accountId) {
		try {
			adminBankAccountService.deleteAccount(accountId);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
