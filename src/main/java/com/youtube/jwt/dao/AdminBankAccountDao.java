package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.AdminAccount;

@Repository
public interface AdminBankAccountDao extends JpaRepository<AdminAccount, Long> {

}
