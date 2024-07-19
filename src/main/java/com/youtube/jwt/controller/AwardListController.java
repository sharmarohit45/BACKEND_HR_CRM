package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.AwardList;
import com.youtube.jwt.service.AwardListService;

@RestController
public class AwardListController {
	@Autowired
	private AwardListService awardService;

	@GetMapping("/award")
	public ResponseEntity<List<AwardList>> getAllAwards() {
		List<AwardList> awards = awardService.getAllAwards();
		return new ResponseEntity<>(awards, HttpStatus.OK);
	}

	// Get an award by ID
	@GetMapping("/award/{id}")
	public ResponseEntity<AwardList> getAwardById(@PathVariable("id") Long id) {
		AwardList award = awardService.getAwardById(id);
		if (award != null) {
			return new ResponseEntity<>(award, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Create a new award
	@PostMapping("/award")
	public ResponseEntity<AwardList> createAward(@RequestBody AwardList awardList) {
		AwardList createdAward = awardService.saveAward(awardList);
		return new ResponseEntity<>(createdAward, HttpStatus.CREATED);
	}

	// Update an existing award
	@PutMapping("/award/{id}")
	public ResponseEntity<AwardList> updateAward(@PathVariable("id") Long id, @RequestBody AwardList awardList) {
		AwardList existingAward = awardService.getAwardById(id);
		if (existingAward != null) {
			awardList.setAwardId(id);
			AwardList updatedAward = awardService.saveAward(awardList);
			return new ResponseEntity<>(updatedAward, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete an award
	@DeleteMapping("/award/{id}")
	public ResponseEntity<Void> deleteAward(@PathVariable("id") Long id) {
		AwardList existingAward = awardService.getAwardById(id);
		if (existingAward != null) {
			awardService.deleteAward(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
