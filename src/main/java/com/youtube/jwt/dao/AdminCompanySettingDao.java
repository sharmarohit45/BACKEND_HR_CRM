package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.AdminCompanySetting;

@Repository
public interface AdminCompanySettingDao extends JpaRepository<AdminCompanySetting, Long> 
{

}
