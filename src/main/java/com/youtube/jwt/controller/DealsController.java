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

import com.youtube.jwt.entity.Deals;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Lead;
import com.youtube.jwt.service.DealsService;
@RestController
public class DealsController {
	@Autowired
	private DealsService dealsService;
	@GetMapping("/deal-count")
	public Long getDealCount() {
		return dealsService.getDealCount();
	}
	@PostMapping("/deals")
    public ResponseEntity<Deals> saveDeals(@RequestBody Deals deals) {
        Deals savedDeals = dealsService.saveDeals(deals);
        return ResponseEntity.ok(savedDeals);
    }
	
	@GetMapping("/deals")
	 public List<Deals> getAllLeads() {
        return dealsService.getAllDeals();
    }
	@GetMapping("/deals/{id}")
    public ResponseEntity<Deals> getDealById(@PathVariable Long id) {
        Optional<Deals> deals = dealsService.getDealById(id);
        return deals.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	@DeleteMapping("/deals/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
	    dealsService.deleteDealById(id);
	    return ResponseEntity.noContent().build();  
	
	}

}
