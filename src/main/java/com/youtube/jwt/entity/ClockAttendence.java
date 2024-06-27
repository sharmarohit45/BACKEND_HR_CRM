package com.youtube.jwt.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClockAttendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String attendanceDate;
    private String attendanceTime;
    private String employeeId;
    private String location;
    private String workingFrom;
    private String otherlocation;
    private String logOutDate;
    private String logOutTime;
    private String day;
	//private LocalDateTime clockInTime;
	//private LocalDateTime clockOutTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getAttendanceTime() {
		return attendanceTime;
	}
	public void setAttendanceTime(String attendanceTime) {
		this.attendanceTime = attendanceTime;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWorkingFrom() {
		return workingFrom;
	}
	public void setWorkingFrom(String workingFrom) {
		this.workingFrom = workingFrom;
	}
	public String getOtherlocation() {
		return otherlocation;
	}
	public void setOtherlocation(String otherlocation) {
		this.otherlocation = otherlocation;
	}
	public String getLogOutDate() {
		return logOutDate;
	}
	public void setLogOutDate(String logOutDate) {
		this.logOutDate = logOutDate;
	}
	public String getLogOutTime() {
		return logOutTime;
	}
	public void setLogOutTime(String logOutTime) {
		this.logOutTime = logOutTime;
	}
	
	
	
}
