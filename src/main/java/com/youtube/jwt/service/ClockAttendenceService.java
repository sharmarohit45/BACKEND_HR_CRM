package com.youtube.jwt.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.ClockAttendenceDao;
import com.youtube.jwt.dao.EmployeeDao;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.ClockAttendence;
import com.youtube.jwt.entity.Contracts;
import com.youtube.jwt.entity.Employee;

@Service
public class ClockAttendenceService {
	@Autowired
	private ClockAttendenceDao clockAttendanceDao;
	
	@Autowired
	private EmployeeDao employeedao;
	
	
	public List<ClockAttendence> getAllClockAttendences() {
        return clockAttendanceDao.findAll();
    }
	public ClockAttendence createClockAttendence(ClockAttendence clockAttendence) {
		Employee employee = employeedao.findById(clockAttendence.getEmployeeId())
	                .orElseThrow(() -> new RuntimeException("Client not found"));
		clockAttendence.setEmployee(employee);
        return clockAttendanceDao.save(clockAttendence);
    }
	
	public ClockAttendence updateClockOutTime(Long employeeId, String attendanceDate, ClockAttendence updatedClockAttendence) {
        List<ClockAttendence> attendences = clockAttendanceDao.findByEmployeeIdAndAttendanceDate(employeeId, attendanceDate);
        
        if (!attendences.isEmpty()) {
            ClockAttendence clockAttendence = attendences.get(attendences.size() - 1); // Get the latest record for that date
            clockAttendence.setLogoutTime(updatedClockAttendence.getLogoutTime());
            clockAttendence.setStatus(updatedClockAttendence.getStatus());
            return clockAttendanceDao.save(clockAttendence);
        }
        throw new RuntimeException("ClockAttendence not found for the given date");
    }
	
	/**public ClockAttendence updateClockOutTime(Long employeeId, ClockAttendence updatedClockAttendence) {
	    ClockAttendence clockAttendence = clockAttendanceDao.findByEmployeeId(employeeId);
	    if (clockAttendence != null && clockAttendence.getAttendanceDate().equals(updatedClockAttendence.getAttendanceDate())) {
	        clockAttendence.setLogoutTime(updatedClockAttendence.getLogoutTime());
	        return clockAttendanceDao.save(clockAttendence);
	    }
	    return null; // Handle appropriately if not found or attendanceDate does not match
	}**/


}
