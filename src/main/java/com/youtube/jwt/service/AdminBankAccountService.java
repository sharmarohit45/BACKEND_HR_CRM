package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.youtube.jwt.dao.AdminBankAccountDao;
import com.youtube.jwt.entity.AdminAccount;
import com.youtube.jwt.exception.EntityNotFoundException;

@Service
public class AdminBankAccountService {
	@Autowired
	private AdminBankAccountDao adminBankAccountDao;

	public AdminAccount saveAccount(AdminAccount adminAccount) {
		return adminBankAccountDao.save(adminAccount);
	}

	public List<AdminAccount> getSaveAccount() {
		return adminBankAccountDao.findAll();
	}

	public void deleteAccount(Long accountID) {
		Optional<AdminAccount> optionalAccount = adminBankAccountDao.findById(accountID);
		if (optionalAccount.isPresent()) {
			adminBankAccountDao.delete(optionalAccount.get());
		} else {
			throw new EntityNotFoundException("AdminAccount not found with id " + accountID);
		}
	}

}
