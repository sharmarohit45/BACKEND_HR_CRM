package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Department;
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
}
