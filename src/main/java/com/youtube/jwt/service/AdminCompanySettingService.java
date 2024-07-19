package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AdminCompanySettingDao;
import com.youtube.jwt.entity.AdminCompanySetting;


@Service
public class AdminCompanySettingService {
@Autowired
private AdminCompanySettingDao adminCompanySettingDao;

public AdminCompanySetting savedata(AdminCompanySetting adminCompanySetting) {
	AdminCompanySetting savedData = adminCompanySettingDao.save(adminCompanySetting);
     return savedData;
}

public List<AdminCompanySetting> getSaveAccount() {
	return adminCompanySettingDao.findAll();
}

}
