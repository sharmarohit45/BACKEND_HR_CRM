package com.youtube.jwt.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Proposal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proposalId;
	 private Long dealId;
	    @ManyToOne
	    @JoinColumn(name = "deals_id", referencedColumnName = "dealId")
	    private Deals deals;
      
	    private Long leadId;
	    @ManyToOne
	    @JoinColumn(name = "lead_iddd", referencedColumnName = "id")
	    private Lead lead;
	    
	    private String validTill;
	    private String currency;
	    private String calculateTax;
	    private String description;
	    private String total;
	    private String date;
	    private String recipientNote;
	    private boolean signatureApproval;
	    @OneToMany(mappedBy = "proposal", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<ProposalProduct> proposalProducts = new ArrayList<>();
	    
	    public void addProposalProduct(ProposalProduct proposalProduct) {
	        proposalProducts.add(proposalProduct);
	        proposalProduct.setProposal(this);
	    }

	    public void removeProposalProduct(ProposalProduct proposalProduct) {
	        proposalProducts.remove(proposalProduct);
	        proposalProduct.setProposal(null);
	    }
	   
		public Long getProposalId() {
			return proposalId;
		}
		public void setProposalId(Long proposalId) {
			this.proposalId = proposalId;
		}
		public Long getDealId() {
			return dealId;
		}
		public void setDealId(Long dealId) {
			this.dealId = dealId;
		}
		public Deals getDeals() {
			return deals;
		}
		public void setDeals(Deals deals) {
			this.deals = deals;
		}
		public Long getLeadId() {
			return leadId;
		}
		public void setLeadId(Long leadId) {
			this.leadId = leadId;
		}
		public Lead getLead() {
			return lead;
		}
		public void setLead(Lead lead) {
			this.lead = lead;
		}
		public String getValidTill() {
			return validTill;
		}
		public void setValidTill(String validTill) {
			this.validTill = validTill;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getCalculateTax() {
			return calculateTax;
		}
		public void setCalculateTax(String calculateTax) {
			this.calculateTax = calculateTax;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isSignatureApproval() {
			return signatureApproval;
		}
		public void setSignatureApproval(boolean signatureApproval) {
			this.signatureApproval = signatureApproval;
		}
		public List<ProposalProduct> getProposalProducts() {
			return proposalProducts;
		}
		public void setProposalProducts(List<ProposalProduct> proposalProducts) {
			this.proposalProducts = proposalProducts;
		}

		public String getTotal() {
			return total;
		}

		public void setTotal(String total) {
			this.total = total;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getRecipientNote() {
			return recipientNote;
		}

		public void setRecipientNote(String recipientNote) {
			this.recipientNote = recipientNote;
		}

		
}
