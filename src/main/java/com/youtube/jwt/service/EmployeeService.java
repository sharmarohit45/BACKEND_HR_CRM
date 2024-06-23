package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.youtube.jwt.dao.EmployeeDao;
import com.youtube.jwt.entity.Employee;
import org.springframework.util.StringUtils;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Employee saveEmployee(Employee employee) {
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        if (employee.getImageData() != null && StringUtils.hasText(employee.getImageName())) {
            String directoryPath = "src/images/employeeImages";
            String imagePath = ImageFileHandler.saveImageDataToFile(directoryPath, employee.getImageName(), employee.getImageData());
            if (imagePath != null) {
                employee.setImageName(imagePath);
            } else {
                // Handle the case where image saving fails
            }
        }
        return employeeDao.save(employee);
    }
    public Optional<Employee> getEmployeeById(Long empId) {
        Optional<Employee> employee = employeeDao.findById(empId);
        if (employee.isEmpty()) {
            //Logger.warning("Employee with ID " + empId + " not found.");
        }
        return employee;
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    public List<Employee> getEmployee() {
        return employeeDao.findAll();
    }
    public void deleteEmployeeById(Long empId) {
    	employeeDao.deleteById(empId);
    }
}