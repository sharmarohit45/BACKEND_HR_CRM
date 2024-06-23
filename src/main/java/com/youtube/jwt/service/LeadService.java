package com.youtube.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.LeadDao;
import com.youtube.jwt.entity.Lead;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {
    @Autowired
    private LeadDao leadDao;

    public Lead saveLead(Lead lead) {
        return leadDao.save(lead);
    }
    public List<Lead> getAllLeads() {
        return leadDao.findAll();
    }
    public Optional<Lead> getClientById(Long id) {
        return leadDao.findById(id);
    }
}
