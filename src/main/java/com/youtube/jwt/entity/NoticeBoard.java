package com.youtube.jwt.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NoticeBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noticeId;
	private String noticeHeading;
	private String department;
	private String type;
	private String noticeDetails;
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeHeading() {
		return noticeHeading;
	}
	public void setNoticeHeading(String noticeHeading) {
		this.noticeHeading = noticeHeading;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNoticeDetails() {
		return noticeDetails;
	}
	public void setNoticeDetails(String noticeDetails) {
		this.noticeDetails = noticeDetails;
	}
	
}
