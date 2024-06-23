package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.jwt.entity.Lead;

public interface LeadDao extends JpaRepository<Lead, Long>{

}
