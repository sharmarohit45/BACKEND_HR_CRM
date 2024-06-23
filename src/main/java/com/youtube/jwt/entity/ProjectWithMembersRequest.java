package com.youtube.jwt.entity;

import java.util.List;

import javax.persistence.Lob;

public class ProjectWithMembersRequest {
	private Project project;
    private List<Long> employeeIds;
    private Long ClientId;
    private String addFileName;
	  @Lob
	 private byte[] addFileData;

    public long getClientId() {
		return ClientId;
	}

	public void setClientId(long ClientId) {
		this.ClientId = ClientId;
	}

	// Getters and Setters
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }
    

}
