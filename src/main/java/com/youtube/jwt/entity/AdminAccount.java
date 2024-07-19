package com.youtube.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class AdminAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountID;

	private String bankName;
	private String accountHolderName;
	private String accountNumber;
	private String accountType;
	private String currency;
	private String contactNumber;
	private String openingBalance;
	private String status;
	private String cashAccountHolderName;
	private String cashAccountNumber;
	private String openingAmount;
	private String cashContactNumber;
	private String cashStatus;
	@Lob
	@Column(name = "bank_data", columnDefinition = "BLOB")
	private byte[] bankData;

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCashAccountHolderName() {
		return cashAccountHolderName;
	}

	public void setCashAccountHolderName(String cashAccountHolderName) {
		this.cashAccountHolderName = cashAccountHolderName;
	}

	public String getCashAccountNumber() {
		return cashAccountNumber;
	}

	public void setCashAccountNumber(String cashAccountNumber) {
		this.cashAccountNumber = cashAccountNumber;
	}

	public String getOpeningAmount() {
		return openingAmount;
	}

	public void setOpeningAmount(String openingAmount) {
		this.openingAmount = openingAmount;
	}

	public String getCashContactNumber() {
		return cashContactNumber;
	}

	public void setCashContactNumber(String cashContactNumber) {
		this.cashContactNumber = cashContactNumber;
	}

	public String getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(String cashStatus) {
		this.cashStatus = cashStatus;
	}

	public byte[] getBankData() {
		return bankData;
	}

	public void setBankData(byte[] bankData) {
		this.bankData = bankData;
	}



	

}
