package com.youtube.jwt.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Holiday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long holidayId;
	private String department;
	private String designation;
	private String employmentType;
	private String holidayDay;
	 @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<HoliDayDateOcassion> holiDayDateOcassion = new ArrayList<>();
	public Long getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(Long holidayId) {
		this.holidayId = holidayId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<HoliDayDateOcassion> getHoliDayDateOcassion() {
		return holiDayDateOcassion;
	}
	public void setHoliDayDateOcassion(List<HoliDayDateOcassion> holiDayDateOcassion) {
		this.holiDayDateOcassion = holiDayDateOcassion;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public String getHolidayDay() {
		return holidayDay;
	}
	public void setHolidayDay(String holidayDay) {
		this.holidayDay = holidayDay;
	}
	
	
}
