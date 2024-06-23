package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.youtube.jwt.entity.Department;

@Service
public interface DepartmentDao extends JpaRepository<Department, Long>  {

}
