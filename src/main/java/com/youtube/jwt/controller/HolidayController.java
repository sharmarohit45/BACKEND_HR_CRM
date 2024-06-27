package com.youtube.jwt.controller;

import java.util.List;
import java.util.Optional;

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

import com.youtube.jwt.entity.Holiday;
import com.youtube.jwt.service.HolidayService;

@RestController
public class HolidayController {
	@Autowired
	private HolidayService holidayService;

	@PostMapping("/holiday")
	public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday Holiday) {
		Holiday createdHoliday = holidayService.createHoliday(Holiday);
		return new ResponseEntity<>(createdHoliday, HttpStatus.CREATED);
	}

	@GetMapping("/holiday")
	public ResponseEntity<List<Holiday>> getAllHoliday() {
		List<Holiday> Holiday = holidayService.getAllHoliday();
		return new ResponseEntity<>(Holiday, HttpStatus.OK);
	}

	@PutMapping("/holiday/{id}")
	public ResponseEntity<Holiday> updateHoliday(@PathVariable Long id, @RequestBody Holiday holiday) {
		Holiday updatedHoliday = holidayService.updateHoliday(id, holiday);
		return new ResponseEntity<>(updatedHoliday, HttpStatus.OK);
	}

	@DeleteMapping("/holiday/{id}")
	public ResponseEntity<Void> deleteHoliday(@PathVariable Long id) {
		holidayService.deleteHoliday(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
