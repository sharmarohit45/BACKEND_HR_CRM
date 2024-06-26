package com.youtube.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Lead;
import com.youtube.jwt.service.LeadService;

@RestController
public class LeadController {
    @Autowired
    private LeadService leadService;
    @GetMapping("/lead-count")
	public Long getLeadCount() {
		return leadService.getLeadCount();
	}
    @PostMapping("/lead")
    public ResponseEntity<Lead> saveLead(@RequestBody Lead lead) {
        Lead savedLead = leadService.saveLead(lead);
        return ResponseEntity.ok(savedLead);
    }
    @GetMapping("/lead")
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }
    @GetMapping("/lead/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable("id") Long id) {
        Optional<Lead> employee = leadService.getLeadById(id);
        return employee.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/lead/{lead_id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long lead_id) {
        Optional<Lead> leadOptional = leadService.getLeadById(lead_id);
        if (leadOptional.isPresent()) {
            leadService.deleteLead(lead_id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
