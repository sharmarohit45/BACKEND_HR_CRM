package com.youtube.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.service.EmployeeService;


@RestController

public class EmployeeContoller {
	
	@Autowired
    private EmployeeService employeeService;
	
	@GetMapping("/employee-count")
    public Long getEmployeeCount() {
        return employeeService.getEmployeeCount();
    }
	@PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestParam("file") MultipartFile file, @ModelAttribute Employee employee) {
        try {
            if (!file.isEmpty()) {
                byte[] imageData = file.getBytes();
                employee.setImageData(imageData);
                employee.setImageName(file.getOriginalFilename());
            }
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return ResponseEntity.ok(savedEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
	@GetMapping("/allEmployee")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployee();
    }
	
	@GetMapping("/employee/{emp_id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long emp_id) {
        Optional<Employee> employee = employeeService.getEmployeeById(emp_id);
        return employee.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
	@DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            employeeService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
