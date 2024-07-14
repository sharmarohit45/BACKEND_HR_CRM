package com.youtube.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HoliDayDateOcassion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String date;
	private String occasion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOccasion() {
		return occasion;
	}
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	@ManyToOne
    @JoinColumn(name = "holiday_id")
	@JsonIgnore
    private Holiday holiday;
	public Holiday getHoliday() {
		return holiday;
	}
	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}

}
