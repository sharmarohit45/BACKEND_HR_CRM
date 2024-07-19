package com.youtube.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class AdminLeave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveId;
	private Long employeeIId;
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "empId")
	private Employee employee;
	private String leaveType;
	private String status;
	private String leaveDuration;
	private String leaveDate;
	private String absenceReason;
	@Lob
	@Column(name = "file_data", columnDefinition = "BLOB")
	private byte[] file;
	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}
	public Long getEmployeeIId() {
		return employeeIId;
	}
	public void setEmployeeIId(Long employeeIId) {
		this.employeeIId = employeeIId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLeaveDuration() {
		return leaveDuration;
	}
	public void setLeaveDuration(String leaveDuration) {
		this.leaveDuration = leaveDuration;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getAbsenceReason() {
		return absenceReason;
	}
	public void setAbsenceReason(String absenceReason) {
		this.absenceReason = absenceReason;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}

}
