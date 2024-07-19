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
public class Appericiation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long awardIId;
	@ManyToOne
	@JoinColumn(name = "award_id", referencedColumnName = "awardId")
	private AwardList awardList;
	private Long employeesId;
	@ManyToOne
	@JoinColumn(name = "employee_Id", referencedColumnName = "empId")
	private Employee employee;
	private String givenDate;
	private String awardSummary;
	@Lob
	@Column(name = "file_data", columnDefinition = "BLOB")
	private byte[] fileData;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAwardIId() {
		return awardIId;
	}
	public void setAwardIId(Long awardIId) {
		this.awardIId = awardIId;
	}
	public AwardList getAwardList() {
		return awardList;
	}
	public void setAwardList(AwardList awardList) {
		this.awardList = awardList;
	}
	public Long getEmployeesId() {
		return employeesId;
	}
	public void setEmployeesId(Long employeesId) {
		this.employeesId = employeesId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getGivenDate() {
		return givenDate;
	}
	public void setGivenDate(String givenDate) {
		this.givenDate = givenDate;
	}
	public String getAwardSummary() {
		return awardSummary;
	}
	public void setAwardSummary(String awardSummary) {
		this.awardSummary = awardSummary;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	

}
