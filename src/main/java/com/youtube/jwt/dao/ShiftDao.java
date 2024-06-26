package com.youtube.jwt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Shift;

@Repository
public interface ShiftDao extends JpaRepository<Shift,Long> {
	List<Shift> findByEmployee(Employee employee);

}
