package com.youtube.jwt.entity;

import java.util.List;

import javax.persistence.Lob;

public class TaskWithMembers {
	private AdminTask adminTask;
    private List<Long> employeeIds;
    private String addFileName;
	  @Lob
	 private byte[] addFileData;
	public AdminTask getAdminTask() {
		return adminTask;
	}
	public void setAdminTask(AdminTask adminTask) {
		this.adminTask = adminTask;
	}
	public List<Long> getEmployeeIds() {
		return employeeIds;
	}
	public void setEmployeeIds(List<Long> employeeIds) {
		this.employeeIds = employeeIds;
	}
	public String getAddFileName() {
		return addFileName;
	}
	public void setAddFileName(String addFileName) {
		this.addFileName = addFileName;
	}
	public byte[] getAddFileData() {
		return addFileData;
	}
	public void setAddFileData(byte[] addFileData) {
		this.addFileData = addFileData;
	}
	  
}
