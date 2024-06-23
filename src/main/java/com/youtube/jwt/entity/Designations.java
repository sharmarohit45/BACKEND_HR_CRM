package com.youtube.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Designations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 public Long designationId;
 
public String name;
 public String parent;
 public Long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getParent() {
	return parent;
}
public void setParent(String parent) {
	this.parent = parent;
}
 
}
