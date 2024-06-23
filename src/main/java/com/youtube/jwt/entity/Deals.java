package com.youtube.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Deals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dealId;
	private String dealName;
	private String pipeline;
	private String dealStages;
	private String dealValue;
	private String closeDate;
	private String dealCategory;
	private String dealAgent;
	private String products;
	private String dealWatcher;
	private Long leadContacts;
	@ManyToOne
	@JoinColumn(name = "leadId", referencedColumnName = "id")
	private Lead lead;

	public Long getLeadContacts() {
		return leadContacts;
	}

	public void setLeadContacts(Long leadContacts) {
		this.leadContacts = leadContacts;
	}

	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public String getPipeline() {
		return pipeline;
	}

	public void setPipeline(String pipeline) {
		this.pipeline = pipeline;
	}

	public String getDealStages() {
		return dealStages;
	}

	public void setDealStages(String dealStages) {
		this.dealStages = dealStages;
	}

	public String getDealValue() {
		return dealValue;
	}

	public void setDealValue(String dealValue) {
		this.dealValue = dealValue;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public String getDealCategory() {
		return dealCategory;
	}

	public void setDealCategory(String dealCategory) {
		this.dealCategory = dealCategory;
	}

	public String getDealAgent() {
		return dealAgent;
	}

	public void setDealAgent(String dealAgent) {
		this.dealAgent = dealAgent;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getDealWatcher() {
		return dealWatcher;
	}

	public void setDealWatcher(String dealWatcher) {
		this.dealWatcher = dealWatcher;
	}

}
