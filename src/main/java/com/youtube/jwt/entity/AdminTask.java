package com.youtube.jwt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AdminTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String taskCategory;
	private String project;
	private String startDate;
	private String dueDate;
	private String projectSummary;
	private String contractType;
	private Double contractValue;
	private String currency;
	@Transient
	private List<Long> employeeIds;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "task_employees", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<Employee> assignedto;
	private String label;
	private String milestones;
	private String status;
	private String extraStatus;
	private Boolean makePrivate;
	private Boolean billable;
	private Integer hrs;
	private Integer minutes;
	private Boolean timeEstimates;
	private Boolean repeat_task;
	private Boolean dependentTask;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTaskCategory() {
		return taskCategory;
	}
	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getProjectSummary() {
		return projectSummary;
	}
	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public Double getContractValue() {
		return contractValue;
	}
	public void setContractValue(Double contractValue) {
		this.contractValue = contractValue;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public List<Long> getEmployeeIds() {
		return employeeIds;
	}
	public void setEmployeeIds(List<Long> employeeIds) {
		this.employeeIds = employeeIds;
	}
	public List<Employee> getAssignedto() {
		return assignedto;
	}
	public void setAssignedto(List<Employee> assignedto) {
		this.assignedto = assignedto;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getMilestones() {
		return milestones;
	}
	public void setMilestones(String milestones) {
		this.milestones = milestones;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExtraStatus() {
		return extraStatus;
	}
	public void setExtraStatus(String extraStatus) {
		this.extraStatus = extraStatus;
	}
	public Boolean getMakePrivate() {
		return makePrivate;
	}
	public void setMakePrivate(Boolean makePrivate) {
		this.makePrivate = makePrivate;
	}
	public Boolean getBillable() {
		return billable;
	}
	public void setBillable(Boolean billable) {
		this.billable = billable;
	}
	public Integer getHrs() {
		return hrs;
	}
	public void setHrs(Integer hrs) {
		this.hrs = hrs;
	}
	public Integer getMinutes() {
		return minutes;
	}
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}
	public Boolean getTimeEstimates() {
		return timeEstimates;
	}
	public void setTimeEstimates(Boolean timeEstimates) {
		this.timeEstimates = timeEstimates;
	}
	public Boolean getRepeat_task() {
		return repeat_task;
	}
	public void setRepeat_task(Boolean repeat_task) {
		this.repeat_task = repeat_task;
	}
	public Boolean getDependentTask() {
		return dependentTask;
	}
	public void setDependentTask(Boolean dependentTask) {
		this.dependentTask = dependentTask;
	}
	public AdminTask saveTask(AdminTask adminTask) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
