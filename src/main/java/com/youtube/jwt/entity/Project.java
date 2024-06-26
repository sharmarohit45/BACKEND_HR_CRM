package com.youtube.jwt.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
public class Project {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String code;
	    private String projectName;
	    private String startDate;
	    private String deadline;
	    private String projectCategory;
	    private String department;
	    @Transient
	    private List<Long> employeeIds;
	    private Long ClientIId;
	    
	    @ManyToOne
	    @JoinColumn(name = "client_id", referencedColumnName = "clientId")
	    private Client client;
	    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	    @JoinTable(
	            name = "projects_employees",
	            joinColumns = @JoinColumn(name = "project_id"),
	            inverseJoinColumns = @JoinColumn(name = "employee_id")
	    )
	    @JsonBackReference
	    private List<Employee> members;
	    private String projectSummery;
	    private String projectNotes;
	    public List<Long> getEmployeeIds() {
			return employeeIds;
		}

		public void setEmployeeIds(List<Long> employeeIds) {
			this.employeeIds = employeeIds;
		}

		

		public String getAddFile() {
			return addFile;
		}

		public Long getClientIId() {
			return ClientIId;
		}

		public void setClientIId(Long clientIId) {
			ClientIId = clientIId;
		}

		public void setAddFile(String addFile) {
			this.addFile = addFile;
		}

		public byte[] getAddFileData() {
			return addFileData;
		}

		public void setAddFileData(byte[] addFileData) {
			this.addFileData = addFileData;
		}

		private String addFile;
		  @Lob
		 private byte[] addFileData;
		private String currency;
		private String budget;
		private String hoursEstimate;
		private boolean allowmanualtimelogs;
		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public String getProjectSummery() {
			return projectSummery;
		}

		public void setProjectSummery(String projectSummery) {
			this.projectSummery = projectSummery;
		}

		public String getProjectNotes() {
			return projectNotes;
		}

		public void setProjectNotes(String projectNotes) {
			this.projectNotes = projectNotes;
		}

		/**public String getAddFile() {
			return addFile;
		}

		public void setAddFile(String addFile) {
			this.addFile = addFile;
		}

		public byte[] getAddFileData() {
			return addFileData;
		}

		public void setAddFileData(byte[] addFileData) {
			this.addFileData = addFileData;
		}**/

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public String getBudget() {
			return budget;
		}

		public void setBudget(String budget) {
			this.budget = budget;
		}

		public String getHoursEstimate() {
			return hoursEstimate;
		}

		public void setHoursEstimate(String hoursEstimate) {
			this.hoursEstimate = hoursEstimate;
		}

		public boolean isAllowmanualtimelogs() {
			return allowmanualtimelogs;
		}

		public void setAllowmanualtimelogs(boolean allowmanualtimelogs) {
			this.allowmanualtimelogs = allowmanualtimelogs;
		}

		public String getMiroBoard() {
			return miroBoard;
		}

		public void setMiroBoard(String miroBoard) {
			this.miroBoard = miroBoard;
		}

		public boolean isCanaccessmiro() {
			return canaccessmiro;
		}

		public void setCanaccessmiro(boolean canaccessmiro) {
			this.canaccessmiro = canaccessmiro;
		}

		public boolean isSendTaskNotification() {
			return sendTaskNotification;
		}

		public void setSendTaskNotification(boolean sendTaskNotification) {
			this.sendTaskNotification = sendTaskNotification;
		}

		private String miroBoard;
		private boolean canaccessmiro;
		private boolean sendTaskNotification;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getProjectName() {
	        return projectName;
	    }

	    public void setProjectName(String projectName) {
	        this.projectName = projectName;
	    }

	    public String getStartDate() {
	        return startDate;
	    }

	    public void setStartDate(String startDate) {
	        this.startDate = startDate;
	    }

	    public String getDeadline() {
	        return deadline;
	    }

	    public void setDeadline(String deadline) {
	        this.deadline = deadline;
	    }

	    public String getProjectCategory() {
	        return projectCategory;
	    }

	    public void setProjectCategory(String projectCategory) {
	        this.projectCategory = projectCategory;
	    }

	    public void setMembers(List<Employee> members) {
	        this.members = members;
	    }

	    public List<Employee> getMembers() {
	        return members;
	    }

}
