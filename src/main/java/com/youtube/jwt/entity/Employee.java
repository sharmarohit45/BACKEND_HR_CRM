package com.youtube.jwt.entity;
import javax.persistence.*;



@Entity
public class Employee {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long empId;
	 private String employeeIdentity;
	 private String Salutation;
	 private String  EmpName;
	 private String email;
	 private String password;
	 private String designation;
	 private String department;
	 private String country;
	 private String mobileNo;
	 private String gender;
	 private String joiningDate;
	 private String dateOfBirth;
	 private String reportingTo;
	 private String language;
	 private String emp_User_Name;
	 private String address;
	 private String about;
	 private String login_Allowed;
	 private String email_Notification;
	 private String hourly_Rate;
	 private String slack_Member_Id;
	 private String skills;
	 private String provision_End_Date;
	 private String notice_Period_Date;
	 private String notice_Period_Enddate;
	 private String employement_Type;
	 private String maritial_State;
	 private String role;
	 private String imageName;
	 
	  @Lob
	  private byte[] imageData;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmployeeIdentity() {
		return employeeIdentity;
	}

	public void setEmployeeIdentity(String employeeIdentity) {
		this.employeeIdentity = employeeIdentity;
	}

	public String getSalutation() {
		return Salutation;
	}

	public void setSalutation(String salutation) {
		Salutation = salutation;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEmp_User_Name() {
		return emp_User_Name;
	}

	public void setEmp_User_Name(String emp_User_Name) {
		this.emp_User_Name = emp_User_Name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getLogin_Allowed() {
		return login_Allowed;
	}

	public void setLogin_Allowed(String login_Allowed) {
		this.login_Allowed = login_Allowed;
	}

	public String getEmail_Notification() {
		return email_Notification;
	}

	public void setEmail_Notification(String email_Notification) {
		this.email_Notification = email_Notification;
	}

	public String getHourly_Rate() {
		return hourly_Rate;
	}

	public void setHourly_Rate(String hourly_Rate) {
		this.hourly_Rate = hourly_Rate;
	}

	public String getSlack_Member_Id() {
		return slack_Member_Id;
	}

	public void setSlack_Member_Id(String slack_Member_Id) {
		this.slack_Member_Id = slack_Member_Id;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getProvision_End_Date() {
		return provision_End_Date;
	}

	public void setProvision_End_Date(String provision_End_Date) {
		this.provision_End_Date = provision_End_Date;
	}

	public String getNotice_Period_Date() {
		return notice_Period_Date;
	}

	public void setNotice_Period_Date(String notice_Period_Date) {
		this.notice_Period_Date = notice_Period_Date;
	}

	public String getNotice_Period_Enddate() {
		return notice_Period_Enddate;
	}

	public void setNotice_Period_Enddate(String notice_Period_Enddate) {
		this.notice_Period_Enddate = notice_Period_Enddate;
	}

	public String getEmployement_Type() {
		return employement_Type;
	}

	public void setEmployement_Type(String employement_Type) {
		this.employement_Type = employement_Type;
	}

	public String getMaritial_State() {
		return maritial_State;
	}

	public void setMaritial_State(String maritial_State) {
		this.maritial_State = maritial_State;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	  
	
	 
	 

}
