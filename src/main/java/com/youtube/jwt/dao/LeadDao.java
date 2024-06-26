package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Lead;
@Repository
public interface LeadDao extends JpaRepository<Lead, Long>{

}
