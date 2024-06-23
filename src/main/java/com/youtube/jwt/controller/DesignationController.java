package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Deals;
import com.youtube.jwt.entity.Designations;
import com.youtube.jwt.service.DesignationService;

@RestController
public class DesignationController {
 @Autowired
 private DesignationService designationService;
 @PostMapping("/designations")
 public ResponseEntity<Designations> saveDesignation(@RequestBody Designations designations)
 {
     Designations saveDesignation = designationService.saveDesignation(designations);
     return ResponseEntity.ok(saveDesignation);
 }
 @GetMapping("/designations")
 public List<Designations> getAllDesignations() {
     return designationService.getAllDesignations();
 }
}
