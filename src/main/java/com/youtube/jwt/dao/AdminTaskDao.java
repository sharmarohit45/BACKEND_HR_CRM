package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.AdminTask;

@Repository
public interface AdminTaskDao extends JpaRepository<AdminTask, Long> {

}
