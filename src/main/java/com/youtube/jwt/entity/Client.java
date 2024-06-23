package com.youtube.jwt.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientId;
	private String salutation;
	private String clientName;
	private String email;
	private String profilePicture;
	private String password;
	private String country;
	private String mobileNo;
	private String gendar;
	private String changeLanguage;
	private String clientCategory;
	private String clientSubCategory;
	private String loginAllowed;
	private String emailNotificationAllowed;
	private String companyName;
	private String officialWebsite;
	private String taxName;
	private String gstVatNumber;
	private String officeNumber;
	private String city;
	private String state;
	private String postalCode;
	private String addedBy;
	private String companyAddress;
	private String shoppingAddress;
	private String note;
	private String companyLogo;
	private String role;
	private String imageProfile;

	@Lob
	private byte[] imageProfileData;

	private String imageLogo;

	@Lob
	private byte[] imageLogoData;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getGendar() {
		return gendar;
	}

	public void setGendar(String gendar) {
		this.gendar = gendar;
	}

	public String getChangeLanguage() {
		return changeLanguage;
	}

	public void setChangeLanguage(String changeLanguage) {
		this.changeLanguage = changeLanguage;
	}

	public String getClientCategory() {
		return clientCategory;
	}

	public void setClientCategory(String clientCategory) {
		this.clientCategory = clientCategory;
	}

	public String getClientSubCategory() {
		return clientSubCategory;
	}

	public void setClientSubCategory(String clientSubCategory) {
		this.clientSubCategory = clientSubCategory;
	}

	public String getLoginAllowed() {
		return loginAllowed;
	}

	public void setLoginAllowed(String loginAllowed) {
		this.loginAllowed = loginAllowed;
	}

	public String getEmailNotificationAllowed() {
		return emailNotificationAllowed;
	}

	public void setEmailNotificationAllowed(String emailNotificationAllowed) {
		this.emailNotificationAllowed = emailNotificationAllowed;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOfficialWebsite() {
		return officialWebsite;
	}

	public void setOfficialWebsite(String officialWebsite) {
		this.officialWebsite = officialWebsite;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public String getGstVatNumber() {
		return gstVatNumber;
	}

	public void setGstVatNumber(String gstVatNumber) {
		this.gstVatNumber = gstVatNumber;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getShoppingAddress() {
		return shoppingAddress;
	}

	public void setShoppingAddress(String shoppingAddress) {
		this.shoppingAddress = shoppingAddress;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImageProfile() {
		return imageProfile;
	}

	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
	}

	public byte[] getImageProfileData() {
		return imageProfileData;
	}

	public void setImageProfileData(byte[] imageProfileData) {
		this.imageProfileData = imageProfileData;
	}

	public String getImageLogo() {
		return imageLogo;
	}

	public void setImageLogo(String imageLogo) {
		this.imageLogo = imageLogo;
	}

	public byte[] getImageLogoData() {
		return imageLogoData;
	}

	public void setImageLogoData(byte[] imageLogoData) {
		this.imageLogoData = imageLogoData;
	}

}
