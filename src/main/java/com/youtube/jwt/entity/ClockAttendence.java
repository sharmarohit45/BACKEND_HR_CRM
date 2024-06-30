package com.youtube.jwt.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class ClockAttendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String attendanceDate;
    private String attendanceTime;
    @Column(name = "employee_id", insertable = false, updatable = false)
    private Long employeeId;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "empId")
    private Employee employee;
    private String location;
    private String workingFrom;
    private String otherlocation;
    private String Status;
    private String logoutTime;
    public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public Employee getEmployee() {
		return employee;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
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
	
	public String getLocation() {
		return location;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
	
	
	
}
