package com.youtube.jwt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.ProposalProductRepository;
import com.youtube.jwt.dao.ProposalRepository;
import com.youtube.jwt.entity.Project;
import com.youtube.jwt.entity.Proposal;
import com.youtube.jwt.entity.ProposalProduct;

@Service
public class ProposalService {
	
	@Autowired
     private ProposalRepository proposalRepository;
	
	@Autowired
	private ProposalProductRepository proposalProductRepository;
	

    public Proposal saveProposal(Proposal proposal) {
        Proposal savedProposal = proposalRepository.save(proposal);
         return savedProposal;
    }
    public List<Proposal> getAllProjects() {
        return proposalRepository.findAll();
    }

}
