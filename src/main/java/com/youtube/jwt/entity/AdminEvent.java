package com.youtube.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
    
    private String eventName;
    private String labelColor;
    private String location;
    private String description;
    private String startsOnDate;
    private String startsOnTime;
    private String endsOnDate;
    private String endsOnTime;
    private String selectedEmployee;
    private String selectedClient;
    private String host;
    private String status;
    private Integer repeatEvery;
    private String repeatInterval;
    private String cycles;
    private String reminderTime;
    private String reminderInterval;
    private String eventLink;
    private String fileUrl;
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLabelColor() {
		return labelColor;
	}
	public void setLabelColor(String labelColor) {
		this.labelColor = labelColor;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartsOnDate() {
		return startsOnDate;
	}
	public void setStartsOnDate(String startsOnDate) {
		this.startsOnDate = startsOnDate;
	}
	public String getStartsOnTime() {
		return startsOnTime;
	}
	public void setStartsOnTime(String startsOnTime) {
		this.startsOnTime = startsOnTime;
	}
	public String getEndsOnDate() {
		return endsOnDate;
	}
	public void setEndsOnDate(String endsOnDate) {
		this.endsOnDate = endsOnDate;
	}
	public String getEndsOnTime() {
		return endsOnTime;
	}
	public void setEndsOnTime(String endsOnTime) {
		this.endsOnTime = endsOnTime;
	}
	public String getSelectedEmployee() {
		return selectedEmployee;
	}
	public void setSelectedEmployee(String selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}
	public String getSelectedClient() {
		return selectedClient;
	}
	public void setSelectedClient(String selectedClient) {
		this.selectedClient = selectedClient;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getRepeatEvery() {
		return repeatEvery;
	}
	public void setRepeatEvery(Integer repeatEvery) {
		this.repeatEvery = repeatEvery;
	}
	public String getRepeatInterval() {
		return repeatInterval;
	}
	public void setRepeatInterval(String repeatInterval) {
		this.repeatInterval = repeatInterval;
	}
	public String getCycles() {
		return cycles;
	}
	public void setCycles(String cycles) {
		this.cycles = cycles;
	}
	public String getReminderTime() {
		return reminderTime;
	}
	public void setReminderTime(String reminderTime) {
		this.reminderTime = reminderTime;
	}
	public String getReminderInterval() {
		return reminderInterval;
	}
	public void setReminderInterval(String reminderInterval) {
		this.reminderInterval = reminderInterval;
	}
	public String getEventLink() {
		return eventLink;
	}
	public void setEventLink(String eventLink) {
		this.eventLink = eventLink;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

}
