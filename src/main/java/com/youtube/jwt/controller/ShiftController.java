package com.youtube.jwt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.entity.Admin;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Shift;
import com.youtube.jwt.service.EmployeeService;
import com.youtube.jwt.service.ShiftService;

@RestController
public class ShiftController {
    
    @Autowired
    private ShiftService shiftService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping("/shift")
    public Shift createShift(@RequestParam("employeeId") Long employeeId,
            @RequestParam("employeeShift") String employeeShift,
            @RequestParam("remark") String remark,
            @RequestParam("date") String date,
            @RequestParam("file") MultipartFile file) throws IOException {

                Optional<Employee> optionalEmployee = employeeService.getEmployeeById(employeeId);
                 Employee employee = optionalEmployee.orElseThrow(() -> new RuntimeException("Employee not found"));
                 Shift shift = new Shift();
                 shift.setEmployee(employee);
                 shift.setEmployeeShift(employeeShift);
                 shift.setRemark(remark);
                  shift.setDate(date);
                  if (!file.isEmpty()) {
  	              byte[] imageLogoData = file.getBytes();
  	             shift.setFileData(imageLogoData);
  	            shift.setFileName(file.getOriginalFilename());
  	            }
                   return shiftService.saveShift(shift);
                }
    @GetMapping("/shift/data")
	public List<Shift> getShiftData() {
        return shiftService.getShiftData();
    }
    
    
}
