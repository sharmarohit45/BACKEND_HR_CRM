package com.youtube.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendenceId;
	private String department;
	private String employee;
	private String location;
	private String markAttendanceBy;
	private String month;
	private String date;
	private String clockIn;
	private String clockOut;
	private String late;
	private String halfDay;
	public Long getAttendenceId() {
		return attendenceId;
	}
	public void setAttendenceId(Long attendenceId) {
		this.attendenceId = attendenceId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMarkAttendanceBy() {
		return markAttendanceBy;
	}
	public void setMarkAttendanceBy(String markAttendanceBy) {
		this.markAttendanceBy = markAttendanceBy;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getClockIn() {
		return clockIn;
	}
	public void setClockIn(String clockIn) {
		this.clockIn = clockIn;
	}
	public String getClockOut() {
		return clockOut;
	}
	public void setClockOut(String clockOut) {
		this.clockOut = clockOut;
	}
	public String getLate() {
		return late;
	}
	public void setLate(String late) {
		this.late = late;
	}
	public String getHalfDay() {
		return halfDay;
	}
	public void setHalfDay(String halfDay) {
		this.halfDay = halfDay;
	}
}
