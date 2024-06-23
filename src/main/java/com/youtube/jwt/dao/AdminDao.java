package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}
