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

import com.youtube.jwt.entity.Department;
import com.youtube.jwt.entity.Lead;
import com.youtube.jwt.service.DepartmentService;

@RestController
public class DepartmentController {
@Autowired
private DepartmentService departmentService;

@PostMapping("/departments")
public ResponseEntity<Department> saveDepartment(@RequestBody Department department)
{
    Department saveDepartment = departmentService.saveDepartment(department);
    return ResponseEntity.ok(saveDepartment);
}
@GetMapping("/departments")
public List<Department> getAllDesignations() {
    return departmentService.getAllDepartment();
}
@PutMapping("/departments/{departmentId}")
public ResponseEntity<Department> updateDepartment(@PathVariable Long departmentId, @RequestBody Department updatedDepartment) {
    Department department = departmentService.updateDepartment(departmentId, updatedDepartment);
    return ResponseEntity.ok(department);
}
@DeleteMapping("/departments/{departmentId}")
public ResponseEntity<Void> deleteDepartment(@PathVariable Long departmentId) {
    departmentService.deleteDepartment(departmentId);
    return ResponseEntity.noContent().build();
}
}
