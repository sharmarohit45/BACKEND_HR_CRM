package com.youtube.jwt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.ClockAttendence;
import com.youtube.jwt.service.ClockAttendenceService;

@RestController
public class ClockAttendanceController {
	@Autowired
	private ClockAttendenceService clockAttendenceService;

	@PostMapping("/clockAttendance/clock-in")
	public ResponseEntity<ClockAttendence> createClockAttendence(@RequestBody ClockAttendence clockAttendence) {
        ClockAttendence createdClockAttendence = clockAttendenceService.createClockAttendence(clockAttendence);
        return new ResponseEntity<>(createdClockAttendence, HttpStatus.CREATED);
    }

	@GetMapping("/clockAttendance/clock-in")
    public ResponseEntity<List<ClockAttendence>> getAllClockAttendences() {
        List<ClockAttendence> clockAttendences = clockAttendenceService.getAllClockAttendences();
        return new ResponseEntity<>(clockAttendences, HttpStatus.OK);
    }
  
}
