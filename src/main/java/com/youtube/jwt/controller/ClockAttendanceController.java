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
        return ResponseEntity.ok(createdClockAttendence);
    }
	
	@PutMapping("/clockAttendance/clock-out/{employeeId}/{attendanceDate}")
    public ResponseEntity<ClockAttendence> updateClockOutTime(
            @PathVariable Long employeeId,
            @PathVariable String attendanceDate,
            @RequestBody ClockAttendence clockAttendence) {
        ClockAttendence updatedClockAttendence = clockAttendenceService.updateClockOutTime(employeeId, attendanceDate, clockAttendence);
        return ResponseEntity.ok(updatedClockAttendence);
    }
	
	/**@PutMapping("/clockAttendance/clock-out/{employeeId}")
    public ResponseEntity<ClockAttendence> updateClockOutTime(@PathVariable Long employeeId, @RequestBody ClockAttendence clockAttendence) {
        ClockAttendence updatedClockAttendence = clockAttendenceService.updateClockOutTime(employeeId, clockAttendence);
        return ResponseEntity.ok(updatedClockAttendence);
    }**/

	@GetMapping("/clockAttendance/clock-in")
    public ResponseEntity<List<ClockAttendence>> getAllClockAttendences() {
        List<ClockAttendence> clockAttendences = clockAttendenceService.getAllClockAttendences();
        return new ResponseEntity<>(clockAttendences, HttpStatus.OK);
    }
  
}
