package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.youtube.jwt.entity.Appericiation;
import com.youtube.jwt.exception.EntityNotFoundException;
import com.youtube.jwt.service.AppericiationService;

@RestController
public class AppericiationController {
	@Autowired
	private AppericiationService appericiationService;
	
	@PostMapping("/appericiation")
	public ResponseEntity<Appericiation> createAward(@RequestBody Appericiation appericiation) {
		Appericiation savedAppericiation = appericiationService.saveAppericiation(appericiation);
		return new ResponseEntity<>(savedAppericiation, HttpStatus.CREATED);
	}
	@GetMapping("/appericiation")
	public List<Appericiation> getAppericiation() {
		return appericiationService.getAllAppericiation();
	}

	 @DeleteMapping("/appericiation/{id}")
	    public ResponseEntity<Void> deleteAppericiation(@PathVariable("id") Long id) {
	        try {
	            appericiationService.deleteAppericiation(id);
	            return ResponseEntity.noContent().build();
	        } catch (EntityNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
