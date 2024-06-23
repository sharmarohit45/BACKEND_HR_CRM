package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Attendence;
import com.youtube.jwt.service.AttendenceService;

@RestController
public class AttendeceController {
@Autowired
private AttendenceService attendenceService;

@PostMapping("/attendence")
public Attendence saveAttendence(@RequestBody Attendence attendence) {
    return attendenceService.saveAttendence(attendence);
}

@GetMapping("/attendence")
public List<Attendence> getAllAttendence() {
    return attendenceService.getAllAttendence();
}
}
