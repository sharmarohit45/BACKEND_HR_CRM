package com.youtube.jwt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.ClockAttendence;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Shift;
@Repository
public interface ClockAttendenceDao extends JpaRepository<ClockAttendence, Long> {
	List<ClockAttendence> findByEmployee(Employee employee);
	ClockAttendence findByEmployeeId(Long employeeId);
	 List<ClockAttendence> findByEmployeeIdAndAttendanceDate(Long employeeId, String attendanceDate);
	 

}
