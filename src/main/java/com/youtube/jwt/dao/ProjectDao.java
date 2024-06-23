package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Project;


@Repository
public interface ProjectDao extends JpaRepository<Project,Long> {
	
	

}
