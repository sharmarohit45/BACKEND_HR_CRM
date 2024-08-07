package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.AdminLeave;

@Repository
public interface AdminLeaveDao extends JpaRepository<AdminLeave, Long> {

}
