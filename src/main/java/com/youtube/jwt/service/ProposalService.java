package com.youtube.jwt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.DealsDao;
import com.youtube.jwt.dao.LeadDao;
import com.youtube.jwt.dao.ProposalProductRepository;
import com.youtube.jwt.dao.ProposalRepository;
import com.youtube.jwt.entity.Deals;
import com.youtube.jwt.entity.Lead;
import com.youtube.jwt.entity.Project;
import com.youtube.jwt.entity.Proposal;
import com.youtube.jwt.entity.ProposalProduct;

@Service
public class ProposalService {
	
	@Autowired
     private ProposalRepository proposalRepository;
	
	@Autowired
	private ProposalProductRepository proposalProductRepository;
	
	@Autowired
	private LeadDao leadDao;
	@Autowired
	private DealsDao dealsDao;
	
    @Transactional
    public Proposal saveProposal(Proposal proposal) {
    	Lead lead = leadDao.findById(proposal.getLeadId())
                .orElseThrow(() -> new RuntimeException("Lead not found"));
    	proposal.setLead(lead);
    	Deals deals = dealsDao.findById(proposal.getDealId())
                .orElseThrow(() -> new RuntimeException("Lead not found"));
    	proposal.setDeals(deals);
        Proposal savedProposal = proposalRepository.save(proposal);
         return savedProposal;
    }
    public List<Proposal> getAllProjects() {
        return proposalRepository.findAll();
    }
    public Proposal getProposalById(Long proposalId) {
        return proposalRepository.findById(proposalId)
                .orElseThrow(() -> new RuntimeException("Proposal not found"));
    }

}
