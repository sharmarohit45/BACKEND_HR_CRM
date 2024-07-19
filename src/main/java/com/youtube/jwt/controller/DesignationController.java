package com.youtube.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Deals;
import com.youtube.jwt.entity.Designations;
import com.youtube.jwt.exception.EntityNotFoundException;
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
 @DeleteMapping("/designations/{id}")
 public ResponseEntity<Void> deleteDesignation(@PathVariable Long id) {
     Optional<Designations> designation = designationService.getDesignationById(id);
     if (designation.isPresent()) {
         designationService.deleteDesignation(id);
         return ResponseEntity.noContent().build();
     } else {
         return ResponseEntity.notFound().build();
     }
 }
 @PutMapping("/designations/{id}")
 public ResponseEntity<Designations> updateDesignation(
         @PathVariable Long id, @RequestBody Designations updatedDesignation) {
     try {
         Designations designation = designationService.updateDesignation(id, updatedDesignation);
         return ResponseEntity.ok(designation);
     } catch (EntityNotFoundException e) {
         return ResponseEntity.notFound().build();
     }
 }
 
}
