package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Designations;

@Repository
public interface DesignationDao extends JpaRepository<Designations, Long> {

}
