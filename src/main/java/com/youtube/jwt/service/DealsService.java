package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.DealsDao;
import com.youtube.jwt.dao.LeadDao;
import com.youtube.jwt.entity.Deals;
import com.youtube.jwt.entity.Lead;

@Service
public class DealsService {
    @Autowired
    private DealsDao dealsDao;
    @Autowired
    private LeadDao leadDao;
    
    public Long getDealCount() {
        return dealsDao.count();
    }
    public Deals saveDeals(Deals deals) {
    	Lead lead = leadDao.findById(deals.getLeadContacts())
                .orElseThrow(() -> new RuntimeException("Lead not found"));
        deals.setLead(lead);
        return dealsDao.save(deals);
    }
    public List<Deals> getAllDeals() {
        return dealsDao.findAll();
    }
    public Optional<Deals> getDealById(Long id) {
        Optional<Deals> deals = dealsDao.findById(id);
        return deals;
    }
    public void deleteDealById(Long id) {
    	dealsDao.deleteById(id);
    }
    
}
