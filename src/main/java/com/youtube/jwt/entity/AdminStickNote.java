package com.youtube.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminStickNote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stickyNoteId;
	private String noteColor;
	private String subject;
	private String createdAt;
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	private String note;
	public Long getStickyNoteId() {
		return stickyNoteId;
	}
	public void setStickyNoteId(Long stickyNoteId) {
		this.stickyNoteId = stickyNoteId;
	}
	public String getNoteColor() {
		return noteColor;
	}
	public void setNoteColor(String noteColor) {
		this.noteColor = noteColor;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}
