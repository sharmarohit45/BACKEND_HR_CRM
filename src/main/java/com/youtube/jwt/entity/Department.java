package com.youtube.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Long departmentId;
public String departmentName;
public String departmentParent;
public Long getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(Long departmentId) {
	this.departmentId = departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public String getDepartmentParent() {
	return departmentParent;
}
public void setDepartmentParent(String departmentParent) {
	this.departmentParent = departmentParent;
}
}
