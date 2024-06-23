package com.youtube.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Lead> getEmployeeById(@PathVariable("id") Long emp_id) {
        Optional<Lead> employee = leadService.getClientById(emp_id);
        return employee.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
